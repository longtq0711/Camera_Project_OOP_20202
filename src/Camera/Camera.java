package Camera;
import Coordinates.Plane;
import Coordinates.Point;
import Coordinates.Vector;

public class Camera {
	private Point point; // toa do camera trong oxyz
    private int highAngle; // goc cao
    private int wideAngle; // goc rong
    private Plane around[] = new Plane[4];
    private Plane bottom;
    private Vector axis;
    public Camera() {
    }

    public Camera(Point point, int highAngle, int wideAngle) {
        this.point = point;
        this.highAngle = highAngle;
        this.wideAngle = wideAngle;
    }
    public Plane[] getAround() {
		return around;
	}
	public void setAround(Plane[] around) {
		this.around = around;
	}
	public Plane getBottom() {
		return bottom;
	}
	public Vector getAxis() {
		return axis;
	}
	public void setAxis() {
		
	}
	public void setTop() {
		bottom = new Plane(point, axis);
	}
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
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
	
//	public boolean canBeSeen(Point p) {
//		//Chay vong for xet cac camera
//		if (p.isInvisible(camera[i])) return true;
//		return false;
//	}
}
