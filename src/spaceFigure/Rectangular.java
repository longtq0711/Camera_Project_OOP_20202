package spaceFigure;
import Coordinates.Plane;
import Coordinates.Point;
import exception.NotReactangularException;

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

	public void addPlane() {
		ArrayList<Point> plane1 = new ArrayList<>();// plane 1 + 2 : mat ben
		ArrayList<Point> plane2 = new ArrayList<>();
		ArrayList<Point> plane3 = new ArrayList<>();// plane 3 + 4 : mat ben
		ArrayList<Point> plane4 = new ArrayList<>();
		ArrayList<Point> plane5 = new ArrayList<>();// plane 5 + 6 : mat tren + mat day
		ArrayList<Point> plane6 = new ArrayList<>();
		for (Point point : points) {
			if (point.getX() == xMin) plane1.add(point);
			else if (point.getX() == xMax) plane2.add(point);
			else if (point.getY() == yMin) plane3.add(point);
			else if (point.getY() == yMax) plane4.add(point);
			else if (point.getZ() == zMax) plane5.add(point); // mat tren
			else if (point.getZ() == zMin) plane6.add(point); // mat day
		}
		planes.add(new Plane(plane1.get(0),plane1.get(1), plane1.get(2)));
		planes.add(new Plane(plane2.get(0),plane2.get(1), plane2.get(2)));
		planes.add(new Plane(plane3.get(0),plane3.get(1), plane3.get(2)));
		planes.add(new Plane(plane4.get(0),plane4.get(1), plane4.get(2)));
		planes.add(new Plane(plane5.get(0),plane5.get(1), plane5.get(2)));
		planes.add(new Plane(plane6.get(0),plane6.get(1), plane6.get(2))); // mat day se o vi tri cuoi cung trong array list
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
				return point.getZ() <= this.zMax && point.getZ() >= this.zMin;
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
