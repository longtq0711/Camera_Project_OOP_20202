package spaceFigure;

import java.util.ArrayList;

import Camera.Camera;
import Coordinates.Plane;
import Coordinates.Point;

public class Room {

    private Rectangular room;

//    private Entity[] entities = new Entity[100];
//    private Camera[] cameras = new Camera[100];
//    private Point[] points = new Point[8]; // 8 diem ABCD A'B'C'D'
//    private Plane[] planes = new Plane[6]; // 6 mat phang

    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<Camera> cameras = new ArrayList<Camera>();
    private ArrayList<Point> points = new ArrayList<Point>();
    private ArrayList<Plane> planes = new ArrayList<Plane>();


    private int countCamera = 0;
    private int countEntity = 0;
    private int countPoint = 0;
    private int countPlane = 0;

    public void addCamera(Camera camera) {
        cameras.add(camera);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void printListCamera() {
        String rs = "";

        for (int i = 0; i < cameras.size(); i++) {
            rs += " (" + cameras.get(i).getPoint().getX() + ", " + cameras.get(i).getPoint().getY() + ", " + cameras.get(i).getPoint().getZ()
                    + ") " + cameras.get(i).getHighAngle() + " " + cameras.get(i).getWideAngle() + "\n";
        }

        System.out.println("Camera: " + rs);
    }

    public void printListEntities() {
        String rs = "";
        for (int i = 0; i < entities.size(); i++) {
            rs += entities.get(i).printListPoint() + "\n";
        }
        System.out.printf("Entities: " + rs);
    }


    public String printListPoint() {
    	Rectangular r = new Rectangular() ;
    	if(!r.isRectangular(points)) System.out.println("This room is not rectangular");
        String rs = "";
        for (int i = 0; i < points.size(); i++) {
            rs += " (" + points.get(i).getX() + ", " + points.get(i).getY() + ", " + points.get(i).getZ() + ") ";
        }
        System.out.println("Point" + rs);
        return rs;
    }



}
