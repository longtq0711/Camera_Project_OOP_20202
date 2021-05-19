package point;

public class CameraPoint {
    private Point point; // tọa độ camera trong oxyz
    private int highAngle; // góc cao
    private int wideAngle; // góc rộng

    public CameraPoint() {
    }

    public CameraPoint(Point point, int highAngle, int wideAngle) {
        this.point = point;
        this.highAngle = highAngle;
        this.wideAngle = wideAngle;
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


}
