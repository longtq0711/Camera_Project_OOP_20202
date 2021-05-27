package spaceFigure;
import Coordinates.Plane;
import Coordinates.Point;
import exception.NotRectangularException;

import java.util.ArrayList;
import java.util.List;

public class Rectangular {

	protected ArrayList<Point> points = new ArrayList<>();
	private ArrayList<Plane> planes = new ArrayList<>();
	
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
		if(!isRectangular(points)) throw new NotRectangularException();
		for(Point point : points) {
			this.points.add(point);
			this.xMax = Float.max(xMax, point.getX());
			this.yMax = Float.max(yMax, point.getY());
			this.zMax = Float.max(zMax, point.getZ());
			this.xMin = Float.min(xMin, point.getX());
			this.yMin = Float.min(yMin, point.getY());
			this.zMin = Float.min(zMin, point.getZ());
		}
		constructPlane();
	}
	
	public Plane getPlane(int index) {
		return planes.get(index);
	}
	
	public List<Plane> getPlanes(){
		return planes;
	}

	public void constructPlane() {
		ArrayList<Point> plane1 = new ArrayList<>();// plane 1 + 2 : mat ben
		ArrayList<Point> plane2 = new ArrayList<>();
		ArrayList<Point> plane3 = new ArrayList<>();// plane 3 + 4 : mat ben
		ArrayList<Point> plane4 = new ArrayList<>();
		ArrayList<Point> plane5 = new ArrayList<>();// plane 5 + 6 : mat tren + mat day
		ArrayList<Point> plane6 = new ArrayList<>();
		for (Point point : points) {
			if (point.getX() == xMin) plane1.add(point);
			if (point.getX() == xMax) plane2.add(point);
			if (point.getY() == yMin) plane3.add(point);
			if (point.getY() == yMax) plane4.add(point);
			if (point.getZ() == zMax) plane5.add(point); // mat tren
			if (point.getZ() == zMin) plane6.add(point); // mat day
		}
		planes.add(new Plane(plane1.get(0),plane1.get(1), plane1.get(2)));
		planes.add(new Plane(plane2.get(0),plane2.get(1), plane2.get(2)));
		planes.add(new Plane(plane3.get(0),plane3.get(1), plane3.get(2)));
		planes.add(new Plane(plane4.get(0),plane4.get(1), plane4.get(2)));
		planes.add(new Plane(plane5.get(0),plane5.get(1), plane5.get(2)));
		planes.add(new Plane(plane6.get(0),plane6.get(1), plane6.get(2))); // mat day se o vi tri cuoi cung trong array list
	}
	public boolean isRectangle(ArrayList<Point> P)
			{
			double cx = 0, cy = 0;
			double dd1,dd2,dd3,dd4;
			for (Point p: P) {
				cx += p.getX();
				cy += p.getY();
			}
			cx=cx/4;
			cy=cy/4;
		
			dd1 = (cx-P.get(0).getX())*(cx-P.get(0).getX()) + (cy-P.get(0).getY())*(cy-P.get(0).getY());
			dd2 = (cx-P.get(1).getX())*(cx-P.get(1).getX()) + (cy-P.get(1).getY())*(cy-P.get(1).getY());
			dd3 = (cx-P.get(2).getX())*(cx-P.get(2).getX()) + (cy-P.get(2).getY())*(cy-P.get(2).getY());
			dd4 = (cx-P.get(3).getX())*(cx-P.get(3).getX()) + (cy-P.get(3).getY())*(cy-P.get(3).getY());
			return dd1==dd2 && dd1==dd3 && dd1==dd4;
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
		if(!isRectangle(P1)) return false;
		for (Point value : P1) {
			for (Point point : P2) {
				if ((value.getX() == point.getX()) && (value.getY() == point.getY())) {
					k++;
				}
			}
		}
		return k == 4;
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
	public boolean contain(Point point) {
		if (point.getX() < this.xMax && point.getX() > this.xMin) {
			if (point.getY() < this.yMax && point.getY() > this.yMin) {
				if (point.getZ() < this.zMax && point.getZ() > this.zMin) 
					return true;
			}
		}
		return false;
	}
	public boolean containEntity(Entity entity) {
		float x1 = entity.getXmax();
		float x2 = entity.getXmin();
		float y1 = entity.getYmax();
		float y2 = entity.getYmin();
		float z1 = entity.getZmax();
		float z2 = entity.getZmin();
		if (x1 < this.xMax && x1 > this.xMin || x2 < this.xMax && x2 > this.xMin) {
			if (y1 < this.yMax && y1 > this.yMin || y2 < this.yMax && y2 > this.yMin) {
				if (z1 < this.zMax && z1 > this.zMin || z2 < this.zMax && z2 > this.zMin) 
					return true;
			}
		}
		return false;
	}
	public boolean duplicate(Rectangular rectangular) {
		if(this.xMax <= rectangular.xMin) return false;
		if(this.yMax <= rectangular.yMin) return false;
		if(this.zMax <= rectangular.zMin) return false;
		if(this.xMin >= rectangular.xMax) return false;
		if(this.yMin >= rectangular.yMax) return false;
		if(this.zMin >= rectangular.zMax) return false;
		return true;
	}

	public boolean has(Rectangular rectangular) {
		for(Point point : rectangular.points) {
			if(this.isContain(point)) return true; 
		}
		return false;
	}
}
