package spaceFigure;
import java.util.ArrayList;

import Coordinates.Plane;
import Coordinates.Point;
public class Entity {
    private ArrayList<Point> points = new ArrayList<Point>();
	private Plane[] planes = new Plane[8];
	private int countPoint = 0;
	private int countPlane = 0;

	public void addPoint(Point point) {
        points.add(point);
    }
	public ArrayList<Point> getPoints() {
        return points;
    }

	public String printListPoint (){

		String rs = "";
		Rectangular r = new Rectangular() ;
    	if(!r.isRectangular(points)) rs = "This Entity is not rectangular";
    	else {
		for (int i = 0; i < points.size(); i++) {
			rs += "(" + points.get(i).getX() + ", " + points.get(i).getY() + ", " + points.get(i).getZ() +") ";
			}
    	}
		return rs;
 
	}
	
//	public boolean isValid(float x,float y,float z){
//		//check xem có hợp lệ không
//	}
//	public boolean isOnFloor(float x,float y,float z) {
//		//check xem có nằm trên sàn không
//	}
//	public boolean isOnEntity(float x,float y,float z) {
//		//check xem có nằm trên vật khác không
//	}
	
	

}
