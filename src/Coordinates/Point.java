package Coordinates;

import spaceFigure.Rectangular;
import spaceFigure.Room;

public class Point {
	float x,y,z;
	
	public Point() {
		x = 0;
		y = 0; 
		z = 0;
	}
	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
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
	
	public float Length(Point a, Point b)
	{
		//Khoang cach giua 2 diem
		float x = (a.getX()-b.getX())*(a.getX()-b.getX());
		float y = (a.getY()-b.getY())*(a.getY()-b.getY());
		float z = (a.getZ()-b.getZ())*(a.getZ()-b.getZ());
		return (float) Math.sqrt(x + y + z);
	}
	public String printPoint(){
		String rs = "";
		rs = "(" + this.x + ", " + this.y + ", " +this.z + ")";

		return rs;
	}
	
}
