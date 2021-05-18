package Coordinates;


public class Vector {
	private float x;
	private float y;
	private float z;

	public float getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}

	public Vector(Point p1, Point p2) { // Tinh vector tu toa do 2 diem
		// TODO Auto-generated constructor stub
		x = p1.getX() - p2.getX();
		y = p1.getY() - p2.getY();
		z = p1.getZ() - p2.getZ();
	}

	public Vector(Vector v1, Vector v2) { // Tim vector phap tuyen
		x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY(); // a2b3 - a3b2
		y = v1.getZ() * v2.getX() - v1.getX() * v2.getZ();//a3b1 - a1b3
		z = v1.getX() * v2.getY() - v1.getY() * v2.getX();//a1b2 - a2b1
	}





}
