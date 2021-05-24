package readfile;

import spaceFigure.Room;

public class CreateRoom {
    private Room room;

    public Room create (){
        ReadFile rf = new ReadFile();
        return this.room = rf.readFile();
    }
}
