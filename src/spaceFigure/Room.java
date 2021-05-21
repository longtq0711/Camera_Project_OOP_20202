package spaceFigure;

import java.util.ArrayList;
import java.util.List;

import Camera.Camera;
import Coordinates.Plane;
import Coordinates.Point;
import exception.CannotPutEntityToRoomException;

public class Room extends Rectangular {

    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<Camera> cameras = new ArrayList<Camera>();
    
    
	public ArrayList<Camera> getCameras() {
		return cameras;
	}
	
	public Room(List<Point> points) {
    	super(points);
    }
    
    public void addCamera(Camera camera) {
        cameras.add(camera);
    }

    public void addEntity(Entity entity) {
    	boolean check = false;
    	// check if we can add the entity to this room
    	for(Entity currentEntity : entities) {
    		if(isPutable(currentEntity, entity)) check = true;
    	}
    	
    	if(isOnFloor(entity)) check = true;
    	if(!check) throw new CannotPutEntityToRoomException();
        entities.add(entity);
    }

    public void printListCamera() {
        String rs = "";

        for (int i = 0; i < cameras.size(); i++) {
            rs += "(" + cameras.get(i).getPosition().getX() + ", " + cameras.get(i).getPosition().getY() + ", " + cameras.get(i).getPosition().getZ()
                    + ") " + cameras.get(i).getHighAngle() + " " + cameras.get(i).getWideAngle() + "\n";
        }

        System.out.println("Camera:\n" + rs);
    }

    public void printListEntities() {
        String rs = "";
        for (int i = 0; i < entities.size(); i++) {
            rs += entities.get(i).printListPoint() + "\n";
        }
        System.out.printf("Entities: \n" + rs);
    }

    public String printListPoint() {
        String rs = "";
        for (int i = 0; i < points.size(); i++) {
            rs += " (" + points.get(i).getX() + ", " + points.get(i).getY() + ", " + points.get(i).getZ() + ") ";
        }
        System.out.println("Point" + rs);
        return rs;
    }
    
	public boolean isInRoom(Entity entity) {
		//check xem co nam trong phong khong
		return this.isContain(entity);
	}
	public boolean isOnFloor(Entity entity) {
		if(!isInRoom(entity)) return false;
		//check xem co nam tren san khong
		int count = 0;
		if (this.isInRoom(entity)) {
			for (int i = 0; i < entity.points.size(); i++) {
				if (entity.points.get(i).getZ() == 0) count++; 
				}
			if (count == 4) return true;
			else return false;
		}
		return false;
	}
	public boolean isPutable(Entity entity1, Entity entity2) {
		Point A1 = new Point(entity2.getXmax(), entity2.getYmax(), entity2.getZmin());
		Point B1 = new Point(entity2.getXmax(), entity2.getYmin(), entity2.getZmin());
		Point C1 = new Point(entity2.getXmin(), entity2.getYmax(), entity2.getZmin());
		Point D1 = new Point(entity2.getXmin(), entity2.getYmin(), entity2.getZmin());
		if(entity1.getZmax() == entity2.getZmin()) {
			if(entity1.isContain(A1)||entity1.isContain(B1)||entity1.isContain(C1)||entity1.isContain(D1))
				return true;
		}
		return false;
	}
}
