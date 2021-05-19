package Coordinates;

public class Line {
	
	private float x;
	private float y;
	private float z;
	
	private Vector u; // Vector chi phuong

	// Constructor
	
	public Line(Point p1, Point p2) {
		u = new Vector(p1, p2);
		x = p1.getX();
		y = p1.getY();
		z = p1.getZ();
	}
	
	public Line(Point p, Vector v) {
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

	public Vector getU() {
		return u;
	}

	public void setU(Vector u) {
		this.u = u;
	}
	//Check xem duong thang co giao voi mat phang khong
		// d :
		// x = x0 + at
		// y = y0 + bt
		// z = z0 + ct
		// S :
		//Ax + By + Cz + D = 0 
		// d = S
		//=>A(x0 + at) + B(y0 + bt) + C(Z0 + ct) + D = 0
		//=> t(Aa + Bb + Cc) = -(Ax0 + By0 + Cz0 + D)
		//=> t = -(Ax0 + By0 + Cz0 + D) / (Aa + Bb + Cc)
		
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
