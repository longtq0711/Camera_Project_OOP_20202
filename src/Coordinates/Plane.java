package Coordinates;

public class Plane {
<<<<<<< HEAD
	public Plane() {
		// TODO Auto-generated constructor stub
=======
	private float a;
	private float b;
	private float c;
	private float d;
	private float area;

	public float getA() {
		return a;
>>>>>>> 3ec97954f053a2ada8322b45484dffecf27c042d
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

	public Plane(Point A, Point B, Point C) {
		// ax + by + cz = d
		Vector AB = new Vector(A, B);
		Vector AC = new Vector(A, C);
		Vector normal = new Vector(AB, AC);// vector phap tuyen
		 a = normal.getX();
		 b = normal.getY();
		 c = normal.getZ();
		 d = -(a*A.getX() + b*A.getY() + c*A.getZ());
		 area = (float)Math.sqrt( a * a + b * b + c * c);
	}

	public boolean isInThePlane(Point A) { // Kiem tra diem thuoc mat phang
		return a * A.getX() + b * A.getY() + c * A.getZ() == d;
	}

	public float distance(Point A) { // Khoang cach tu diem A den mat phang
		d = Math.abs(a * A.getX() + b * A.getY() + c * A.getZ());// ax + by + cz = d
		float e = (float)Math.sqrt(a * a + b * b + c * c); // Mau so
		return d / e;
	}



}
