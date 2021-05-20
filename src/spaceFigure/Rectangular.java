package spaceFigure;
import java.util.ArrayList;
import java.util.List;

import Coordinates.Plane;
import Coordinates.Point;
import exception.NotReactangularException;

public class Rectangular {

	protected ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Plane> planes = new ArrayList<Plane>();
	
	private float xmax = Float.MIN_VALUE, ymax = Float.MIN_VALUE, zmax = Float.MIN_VALUE;
	private float xmin = Float.MAX_VALUE, ymin = Float.MAX_VALUE, zmin = Float.MAX_VALUE;
	public float getXmax() {
		return xmax;
	}

	public float getYmax() {
		return this.ymax;
	}

	public float getZmax() {
		return this.zmax;
	}

	public float getXmin() {
		return this.xmin;
	}

	public float getYmin() {
		return this.ymin;
	}

	public float getZmin() {
		return this.zmin;
	}
	public Rectangular(List<Point> points) {
		super();
		if(!isRectangular(points)) throw new NotReactangularException();
		for(Point point : points) {
			this.points.add(point);
			this.xmax = Float.max(xmax, point.getX());
			this.ymax = Float.max(ymax, point.getY());
			this.zmax = Float.max(zmax, point.getZ());
			this.xmin = Float.min(xmin, point.getX());
			this.ymin = Float.min(ymin, point.getY());
			this.zmin = Float.min(zmin, point.getZ());
		}
	}
	
	public boolean isRectangular(List<Point> points){
		ArrayList<Point> P1 = new ArrayList<>();
		ArrayList<Point> P2 = new ArrayList<>();
		//check xem co phai hhcn khong
		int k = 0;
		for(Point point: points) {
			if (P1.isEmpty()) P1.add(point);
			else {
				if (point.getZ() == P1.get(0).getZ()) P1.add(point);
				else {
					if (P2.isEmpty()) P2.add(point);
					else {
						if(point.getZ() == P2.get(0).getZ()) P2.add(point);
						else return false;
					}
				}
			}
		}
		
		for(int i=0; i<P1.size(); i++) {
			for(int j=0; j<P2.size(); j++) {
				if((P1.get(i).getX() == P2.get(j).getX()) && (P1.get(i).getY() == P2.get(j).getY())) {
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
	
	public boolean isContain(Point point) {
		// TODO check
		if (point.getX() <= this.xmax && point.getX() >= this.xmin) {
			if (point.getY() <= this.ymax && point.getY() >= this.ymin) {
				if (point.getZ() <= this.zmax && point.getZ() >= this.zmin) 
					return true;
			}
		}
		return false;
	}
	
	public boolean isContain(Rectangular rectangular) {
		for(Point point : rectangular.points) {
			if(!this.isContain(point)) return false; 
		}
		return true;
	}
}
