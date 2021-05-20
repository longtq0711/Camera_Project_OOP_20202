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
	
//	public boolean isInRectangular(Rectangular rectangular) {
//		if (this.x <= rectangular.getXmax() && this.x >= rectangular.getXmin()) {
//			if (this.y <= rectangular.getYmax() && this.y >= rectangular.getYmin()) {
//				if (this.z <= rectangular.getZmax() && this.z >= rectangular.getZmin()) 
//					return true;
//			}
//		}
//		return false;
//	}
	
//	public boolean isInCamera(Camera cam) {
//		//Check xem co o trong hinh chop tao thanh boi camera khong 	
//	}
//	public boolean isInRoom(Room room){
//		//Check xem co o trong phong khong
//	}
//	public float callDistance(Entity entity) {
//		//Khoang cach den Entity
//	}
//
//	public boolean isInEntity(Entity entity) {
//		//Kiem tra xem co co trong Entity khong
//	}
	
	//Check xem co the nhin thay duoc khong:
	// 1. Nam trong phong va trong vung hinh chop tao boi camera
	// 2. Nam ngoai vat the va duong thang noi diem dat camera den diem can xet khong
	// giao voi 2 mat phang tro len cua vat the
//	public boolean isInvisible(Camera cam) {
//		Point p;
//		int count = 0;
//		if (p.isInRoom && p.isInCamera) {
//			line = new Line(p, cam.point);
//			if (!p.isInEntiTy) return false;
//			else {
//				//Chay 1 vong for xet cac vat the
//				count = 0;
//				//Chay 1 vong for xet 6 mat cua vat the
//				if(line.intersection(entity.plane) != null) count++;
//				//ket thuc vong for
//				if(count >= 2) return false
//				//ket thuc vong for
//				return true;
//			}
//			return false;
//			}

//	}

	
}
