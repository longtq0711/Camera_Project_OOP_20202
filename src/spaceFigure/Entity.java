package spaceFigure;
import Coordinates.Plane;
import Coordinates.Point;
public class Entity {

	private Point[] points = new Point[8];
	private Plane[] planes = new Plane[8];
	private int countPoint = 0;
	private int countPlane = 0;

	public void addPoint(Point point){
		points[countPoint++] = point;
	}

	public String printListPoint (){
		String rs = "";
		for (int i = 0; i < countPoint; i++) {
			rs += " (" + points[i].getX() + ", " + points[i].getY() + ", " + points[i].getZ() +") ";

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
