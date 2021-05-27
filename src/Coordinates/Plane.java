package Coordinates;

public class Plane {
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

	public Plane(Point p1, Vector2D v) {
		a = v.getX();
		b = v.getY();
		c = v.getZ();
		d = - (a*p1.getX() + b*p1.getY() + c*p1.getZ());
	}

	public Plane(Point A, Point B, Point C) {
		// ax + by + cz + d = 0
			Vector2D AB = new Vector2D(A, B);
			Vector2D AC = new Vector2D(A, C);
			Vector2D normal = new Vector2D(AB, AC);// vector phap tuyen
			 a = normal.getX();	
			 b = normal.getY();
			 c = normal.getZ();
			 d = -(a*A.getX() + b*A.getY() + c*A.getZ());
			 area = (float)Math.sqrt(a * a + b * b + c * c);
	}




	


}
