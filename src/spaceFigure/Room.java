package spaceFigure;

import java.util.ArrayList;

import Camera.Camera;
import Coordinates.Plane;
import Coordinates.Point;

public class Room {

    private Rectangular room;
    private Entity[] entities = new Entity[100];
    private Camera[] cameras = new Camera[100];
    private Point[] points = new Point[8]; // 8 điểm ABCD A'B'C'D'
    private Plane[] planes = new Plane[8]; // 8 Mặt phẳng của room
    private int countCamera = 0;
    private int countEntity = 0;
    private int countPoint = 0;
    private int countPlane = 0;

    public void addCamera(Camera camera) {
        cameras[countCamera++] = camera;
    }

    public void addEntity(Entity entity) {
        entities[countEntity++] = entity;
    }

    public void addPoint(Point point) {
        points[countPoint++] = point;
    }

    public void printListCamera() {
        String rs = "";
        for (int i = 0; i < countCamera; i++) {
            rs += " (" + cameras[i].getPoint().getX() + ", " + cameras[i].getPoint().getY() + ", " + cameras[i].getPoint().getZ()
                    + ") " + cameras[i].getHighAngle() + " " + cameras[i].getWideAngle() + "\n";
        }
        System.out.println(rs);
    }

    public void printListEntities() {
        String rs = "";
        for (int i = 0; i < countEntity; i++) {
            rs += entities[i].printListPoint() + "\n";
        }
        System.out.printf(rs);
    }


    public String printListPoint() {
        String rs = "";
        for (int i = 0; i < countPoint; i++) {
            rs += " (" + points[i].getX() + ", " + points[i].getY() + ", " + points[i].getZ() + ") ";
        }
        System.out.println(rs);
        return rs;
    }
}
