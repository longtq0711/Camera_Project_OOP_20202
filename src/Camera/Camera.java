package Camera;
import Coordinates.Plane;
import Coordinates.Point;
import Coordinates.Vector2D;
import spaceFigure.Rectangular;
import spaceFigure.Room;

public class Camera {
	private Point position; // toa do camera trong oxyz
    private int highAngle; // goc cao
    private int wideAngle; // goc rong
    private Plane around[] = new Plane[4];
    private Plane bottom;
    public Camera() {
    }

    public Camera(Point point, int highAngle, int wideAngle) {
        this.position = point;
        this.highAngle = highAngle;
        this.wideAngle = wideAngle;
    }
    public Plane[] getAround() {
		return around;
	}
	public void setAround(Plane[] around) {
		this.around = around;
	}

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point point) {
        this.position = point;
    }

    public int getHighAngle() {
        return highAngle;
    }

    public void setHighAngle(int highAngle) {
        this.highAngle = highAngle;
    }

    public int getWideAngle() {
        return wideAngle;
    }

    public void setWideAngle(int wideAngle) {
        this.wideAngle = wideAngle;
    }
	
    public boolean checkCameraInRoom(Room room) {
    	if(room.isContain(position)) {
    		if(position.getZ() == room.getZmax() || position.getX() == room.getXmax() || position.getX() == 0
    				|| position.getY() == room.getYmax() || position.getY() == 0) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	return false;
    }
    public boolean isInCameraView(Point p, Camera camera, Plane plane){
    	//Check xem 1 diem co nam trong vung nhin thay cua camera hay khong
    }

}
