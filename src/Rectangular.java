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
			if (P1.get(k) == null) P1.add(point);
			else {
				if (point.getZ() == P1.get(k).getZ()) P1.add(point);
				else {
					if (P2.get(k) == null) P2.add(point);
					else {
						if(point.getZ() == P2.get(k).getZ()) P2.add(point);
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
}
