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
	
	public boolean check(Point p) {
		//Check 2 diem trung nhau
		if(x != p.x)
			return false;
		if(y != p.y)
			return false;
		if(z != p.z)
			return false;
		return true;
	}
	
	public boolean isBetween(Point p1, Point p2) { 
		// Xac dinh diem p co nam giua 2 diem p1 va p2 hay ko
		// Chi ap dung cho 3 diem thang hang
		// Neu (p1 -p)(p2 - p) < 0 -> diem p nam giua p1 va p2
		if(check(p1) || check(p2))
			return false;
		
		if((p1.x - this.x)*(p2.x - this.x) > 0)
			return false;
		if((p1.y - this.y)*(p2.y - this.y) > 0)
			return false;
		if((p1.z - this.z)*(p2.z - this.z) > 0)
			return false;
		return true;
	}

	public String printPoint(){
		return  "(" + this.x + ", " + this.y + ", " +this.z + ")";
	}
	public boolean checkPointExists(Point p){

		return (this.x == p.getX() && this.y == p.getY() && this.z == p.getZ()) ? true : false;
	}
	
}
