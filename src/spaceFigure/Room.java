package spaceFigure;

import Camera.Camera;
import Coordinates.Line;
import Coordinates.Plane;
import Coordinates.Point;
import exception.CannotPutEntityToRoomException;

import java.util.ArrayList;
import java.util.List;

public class Room extends Rectangular {

    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Camera> cameras = new ArrayList<>();
    private ArrayList<Plane> planes = new ArrayList<>();
    private int count = 0;
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
    	if (count < 1) if(isOnFloor(entity)) check = true;
    	
    	if(!check) throw new CannotPutEntityToRoomException();
        entities.add(entity);
        count++;
    }

    public void printListCamera() {
        StringBuilder rs = new StringBuilder();

        for (int i = 0; i < cameras.size(); i++) {
            rs.append("(").append(cameras.get(i).getPosition().getX()).append(", ").append(cameras.get(i).getPosition().getY()).append(", ").append(cameras.get(i).getPosition().getZ()).append(") ").append(cameras.get(i).getHighAngle()).append(" ").append(cameras.get(i).getWideAngle()).append("\n");
        }

        System.out.println("Camera:\n" + rs);
    }

    public void printListEntities() {
        StringBuilder rs = new StringBuilder();
		for (Entity entity : entities) {
			rs.append(entity.printListPoint()).append("\n");
		}
        System.out.print("Entities: \n" + rs);
    }

    public void printListPoint() {
        StringBuilder rs = new StringBuilder();
		for (Point point : points) {
			rs.append(" (").append(point.getX()).append(", ").append(point.getY()).append(", ").append(point.getZ()).append(") ");
		}
        System.out.println("Point" + rs);
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
			return count == 4;
		}
		return false;
	}
	public boolean isPutable(Entity entity1, Entity entity2) {
		Point A1 = new Point(entity2.getXmax(), entity2.getYmax(), entity2.getZmin());
		Point B1 = new Point(entity2.getXmax(), entity2.getYmin(), entity2.getZmin());
		Point C1 = new Point(entity2.getXmin(), entity2.getYmax(), entity2.getZmin());
		Point D1 = new Point(entity2.getXmin(), entity2.getYmin(), entity2.getZmin());
		if(this.isInRoom(entity2)) {
			for (int i = 0; i < entity2.points.size(); i++) {
					if (entity1.isContain(points.get(i))) return false; 
			}
			if (entity1.getZmax() == entity2.getZmin()) {
				if(entity1.isContain(A1) || entity1.isContain(B1) || entity1.isContain(C1) || entity1.isContain(D1)) return true;
			}
		}
		return false;
	}
	//Check xem co the nhin thay duoc khong:
		// 1. Nam trong phong va trong vung hinh chop tao boi camera
		// 2. Nam ngoai vat the va duong thang noi diem dat camera den diem can xet khong
		// giao voi 2 mat phang tro len cua vat the
	
	public boolean canBeSeen(Point p, Room r) {
		List<Plane> roomPlanes = r.getPlanes();
		for(Camera camera: cameras) {
			int count = 0;
			for (Plane roomPlane: roomPlanes) {
			if (camera.isInCameraView(p, roomPlane)) {
				Line line = new Line(p, camera.getPosition());
				for (Entity entity: entities) {
					if (entity.isContain(p)) return false;
					count = 0;
					List<Plane> entityPlanes = entity.getPlanes();
					for (Plane entityPlane: entityPlanes) {
						if(line.intersection(entityPlane)!= null) count++;
						}
					if(count >= 2) return false;
					}
				}
			}
		}
		return true;
	}
}

