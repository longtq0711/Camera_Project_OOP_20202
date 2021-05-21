package spaceFigure;
import java.util.ArrayList;
import java.util.List;

import Coordinates.Plane;
import Coordinates.Point;
public class Entity extends Rectangular {
	
	public Entity(List<Point> points) {
		super(points);
	}

	public String printListPoint (){
		String rs = "";
		for (int i = 0; i < points.size(); i++) {
			rs += "(" + points.get(i).getX() + ", " + points.get(i).getY() + ", " + points.get(i).getZ() +") ";
			}
 
		return rs;
 
	}

}
