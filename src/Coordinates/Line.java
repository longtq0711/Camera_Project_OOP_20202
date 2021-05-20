package Coordinates;

public class Line {
	
	private float x;
	private float y;
	private float z;
	
	private Vector2D u; // Vector chi phuong

	// Constructor
	
	public Line(Point p1, Point p2) {
		u = new Vector2D(p1, p2);
		x = p1.getX();
		y = p1.getY();
		z = p1.getZ();
	}
	
	public Line(Point p, Vector2D v) {
		u = v;
		x = p.getX();
		y = p.getY();
		z = p.getZ();
	}
	
	// Getter & Setter
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
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
			float t = -(p.getA()*x + p.getB()*y + p.getC()*z + p.getD()) / mau;
			if(!Float.isNaN(t) || !Float.isInfinite(t)) {
				return new Point(x + u.getX()*t, y + u.getY()*t, z + u.getZ()*t);
			}
			return null;
		}
}
