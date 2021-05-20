package Coordinates;

public class Plane {
	public Plane() {
		// TODO Auto-generated constructor stub
	}
	private float a;
	private float b;
	private float c;
	private float d;
	private float area;

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
		this.c = c;
	}

	public float getD() {
		return d;
	}

	public void setD(float d) {
		this.d = d;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}
	public Plane(Point p1, Vector v) {
		a = v.getX();
		b = v.getY();
		c = v.getZ();
		d = - (a*p1.getX() + b*p1.getY() + c*p1.getZ());
	}
	public Plane(Point A, Point B, Point C) {
		// ax + by + cz = d
		if(isTruePlane(A,B,C)) {
			Vector AB = new Vector(A, B);
			Vector AC = new Vector(A, C);
			Vector normal = new Vector(AB, AC);// vector phap tuyen
			 a = normal.getX();
			 b = normal.getY();
			 c = normal.getZ();
			 d = -(a*A.getX() + b*A.getY() + c*A.getZ());
			 area = (float)Math.sqrt( a * a + b * b + c * c);
		}
	}

	public boolean isInThePlane(Point A) { // Kiem tra diem thuoc mat phang
		return a * A.getX() + b * A.getY() + c * A.getZ() == d;
	}

	public float distance(Point A) { // Khoang cach tu diem A den mat phang
		d = Math.abs(a * A.getX() + b * A.getY() + c * A.getZ());// ax + by + cz = d
		float e = (float)Math.sqrt(a * a + b * b + c * c); // Mau so
		return d / e;
	}

	public boolean isTruePlane(Point A, Point B, Point C) { // Kiem tra xem 3 diem co nam o mat phang phu hop khong ( may day, mat ben)
		if( ((A.getX() == B.getX()) && (B.getX() == C.getX())) 
			|| ((A.getY() == B.getY()) && (B.getY() == C.getY())) 
			|| ((A.getZ() == B.getZ()) && (B.getZ() == C.getZ()))) {
			return true;
		}
		return false;
	}
	
	public boolean isTruePlane(Point A, Point B, Point C, Point D) { // Kiem tra xem 4 diem co nam o mat phang phu hop khong ( may day, mat ben)
		if( ((A.getX() == B.getX()) && (B.getX() == C.getX()) && (C.getX() == D.getX())) 
			|| ((A.getY() == B.getY()) && (B.getY() == C.getY()) && (C.getY() == D.getY())) 
			|| ((A.getZ() == B.getZ()) && (B.getZ() == C.getZ()) && (C.getZ() == D.getZ()))) {
			return true;
		}
		return false;
	}

}
