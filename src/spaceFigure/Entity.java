package spaceFigure;
import java.util.List;
import Coordinates.Point;
public class Entity extends Rectangular {
	
	public Entity(List<Point> points) {
		super(points);
	}

	public String printListPoint (){
		StringBuilder rs = new StringBuilder();
		for (Point point : points) rs.append("(").append(point.getX()).append(", ").append(point.getY()).append(", ").append(point.getZ()).append(") ");
 
		return rs.toString();
	}

}
