package spaceFigure;
import java.util.ArrayList;
import java.util.List;

import Coordinates.Plane;
import Coordinates.Point;
import exception.NotReactangularException;

public class Rectangular {

	protected ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Plane> planes = new ArrayList<Plane>();
	
	private float xMax = Float.MIN_VALUE, yMax = Float.MIN_VALUE, zMax = Float.MIN_VALUE;
	private float xMin = Float.MAX_VALUE, yMin = Float.MAX_VALUE, zMin = Float.MAX_VALUE;
	public float getXmax() {
		return this.xMax;
	}

	public float getYmax() {
		return this.yMax;
	}

	public float getZmax() {
		return this.zMax;
	}

	public float getXmin() {
		return this.xMin;
	}

	public float getYmin() {
		return this.yMin;
	}

	public float getZmin() {
		return this.zMin;
	}
	public Rectangular(List<Point> points) {
		super();
		if(!isRectangular(points)) throw new NotReactangularException();
		for(Point point : points) {
			this.points.add(point);
			this.xMax = Float.max(xMax, point.getX());
			this.yMax = Float.max(yMax, point.getY());
			this.zMax = Float.max(zMax, point.getZ());
			this.xMin = Float.min(xMin, point.getX());
			this.yMin = Float.min(yMin, point.getY());
			this.zMin = Float.min(zMin, point.getZ());
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
	
	public boolean isContain(Point point) {
		// TODO check
		if (point.getX() <= this.xMax && point.getX() >= this.xMin) {
			if (point.getY() <= this.yMax && point.getY() >= this.yMin) {
				if (point.getZ() <= this.zMax && point.getZ() >= this.zMin) 
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
