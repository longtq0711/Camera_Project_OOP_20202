package spaceFigure;

import point.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// hình chữ nhật
public class Rectangle {
    private List<Point> points = new ArrayList<>();
    private int count = 0;

    public boolean addPoint(Point point) {
        if (this.count <= 8) {
            points.add(point);
            this.count++;
            return true;
        } else return false;
    }

    public String printPointsList() {
        Iterator i = points.iterator();
        String result = "";
        while (i.hasNext()) {
            Point p = (Point) i.next();
            result += " ( " + p.getX() + ", " + p.getY() + ", " + p.getY() + " ) ";
        }
        System.out.println(result);
        return  result;
    }

    // check xem có phải là hình chữ nhật không
    public boolean isRectangle(){
        return true;
    }
}
