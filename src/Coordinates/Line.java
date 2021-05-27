package Coordinates;

public class Line {
	
	private float a;
	private float b;
	private float c;
	
	private Vector2D u; // Vector chi phuong

	// Constructor
	
	public Line(Point p1, Point p2) {
		u = new Vector2D(p1, p2);
		a = p1.getX();
		b = p1.getY();
		c = p1.getZ();
	}
	
	// Getter & Setter
<<<<<<< HEAD
	public float getX() {
		return a;
	}

	public void setX(float x) {
		this.a = a;
	}

	public float getY() {
		return b;
	}

	public void setY(float y) {
		this.b = b;
	}

	public float getZ() {
		return c;
	}

	public void setZ(float z) {
=======


	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getC() {
		return c;
	}

	public void setC(float c) {
>>>>>>> a85f63c7c6602a13dd59f31702508c2a473248a2
		this.c = c;
	}

	public Vector2D getU() {
		return u;
	}

	public void setU(Vector2D u) {
		this.u = u;
	}
	//Check xem duong thang co giao voi mat phang khong

	public Point intersection(Plane p) {
		float mau = (p.getA()*u.getX() + p.getB()*u.getY() + p.getC()*u.getZ());
		if(mau == 0) return null;
		float t = -(p.getA()*a + p.getB()*b + p.getC()*c + p.getD()) / mau;
		if(!Float.isNaN(t) || !Float.isInfinite(t)) {
			return new Point(a + u.getX()*t, b + u.getY()*t, c + u.getZ()*t);
		}
		return null;
	}
}
