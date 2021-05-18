package Coordinates;

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
	
	public float callDistance(Entity entity) {
		//Khoang cach den Entity
	}
	
	public boolean isInEntity(Entity entity) {
		//Kiem tra xem co co trong Entity khong
	}
	

}
