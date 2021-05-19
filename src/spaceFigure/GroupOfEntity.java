package spaceFigure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupOfEntity {
    private List<Entity> entities = new ArrayList<>();
    private int count = 0;
    public void addEntities (Entity entity){
        entities.add(entity);
        count++;
    }
    public void printListEntities (){
        Iterator i = entities.iterator();
        String rs = "";
        while (i.hasNext()){
            Entity e = (Entity) i.next();
            rs += e.printPointsList() + "\n";
        }
    }

}
