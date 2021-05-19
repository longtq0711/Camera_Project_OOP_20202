import java.util.ArrayList;

import Coordinates.Point;

public class Rectangular {
	private ArrayList<Point> P1 = new ArrayList<>();
	private ArrayList<Point> P2 = new ArrayList<>();
	public Rectangular() {
		// TODO Auto-generated constructor stub
	}
	public boolean isRectangular(ArrayList<Point> points){
		//check xem co phai hhcn khong
		int k = 0;
		for(Point point: points) {
			if (this.P1.get(k) == null) this.P1.add(point);
			else {
				if (point.getZ() == this.P1.get(k).getZ()) this.P1.add(point);
				else {
					if (this.P2.get(k) == null) this.P2.add(point);
					else {
						if(point.getZ() == this.P2.get(k).getZ()) this.P2.add(point);
						else return false;
					}
				}
			}
		}
		for(int i=0; i<this.P1.size(); i++) {
			for(int j=0; j<this.P2.size(); j++) {
				if((this.P1.get(i).getX() == this.P2.get(j).getX()) && (this.P1.get(i).getY() == this.P2.get(j).getY())) {
					k++;
					continue;
				}
					
			}
		}
		if (k==4) return true;
		return false;
	}
	public float Volume(ArrayList<Point> points) {
		//The tich hinh hop
		float h = points.get(0).getZ();
		float a = points.get(0).getX();
		float b = points.get(0).getZ();
		for(Point point: points) {
			if (point.getX()!= h) h = Math.abs(h - point.getZ()); 
			if (point.getX()!= a) a = Math.abs(a - point.getX()); 
			if (point.getX()!= b) b = Math.abs(b - point.getY()); 
		}
		return a*b*h;
	}
}
