package readfile;

import Camera.Camera;
import Coordinates.Plane;
import Coordinates.Point;
import exception.CannotPutEntityToRoomException;
import exception.CannotSetCameraInRoomException;
import exception.NotRectangularException;
import spaceFigure.Entity;

import spaceFigure.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public Room readFile(){
        Room room = null;
        List<Point> roomPoints = new ArrayList<>();
        int countEntity, countCamera;

        StringSplit stringSplit = new StringSplit();
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/readfile/input.txt"))) {
            // dia chi toi file
        	
            // dong 1 toa do 4 diem A, B, C, D
            String lineRoom = br.readLine();
            String[] rs1 = stringSplit.deleteAndSplit(lineRoom);
            for (int i = 0; i < rs1.length; i += 3) {
                Point p = new Point(Float.parseFloat(rs1[i]), Float.parseFloat(rs1[i + 1]), Float.parseFloat(rs1[i + 2]));
                roomPoints.add(p);
            }
            try {
            	room = new Room(roomPoints);
            	room.printListPoint();
            	List<Plane> planes = room.getPlanes();
            	for(Plane plane : planes) {
            		System.out.println(plane.getA() + " " + plane.getB() + " " + plane.getC() + " " + plane.getD());
            	}
            } catch (NotRectangularException e) {
            	System.out.println("This room is not rectangular");
            }
            // room
           
            countEntity = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < countEntity; i++) {
            	List<Point> entityPoints = new ArrayList<Point>();
                String lineEntity = br.readLine();
                String[] rs2 = stringSplit.deleteAndSplit(lineEntity);
                for (int j = 0; j < rs2.length; j += 3) {
                    Point p = new Point(Float.parseFloat(rs2[j]), Float.parseFloat(rs2[j + 1]), Float.parseFloat(rs2[j + 2]));
                    entityPoints.add(p);
                }
				try {
                    Entity entity = new Entity(entityPoints);
                    room.addEntity(entity);
                    room.printListEntities();
                } catch (NotRectangularException e) {
                	System.out.println("One of entities is not rectangular");
                } catch (CannotPutEntityToRoomException e) {
                	System.out.println("Fail to add entity");
                }
            }
            room.printListEntities();

            countCamera = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < countCamera; i++) {
                String lineCamera = br.readLine();
                String[] rs3 = stringSplit.deleteAndSplit(lineCamera);
                Camera c = new Camera();
                for (int j = 0; j < rs3.length; j += 5) {
                    Point p = new Point(Float.parseFloat(rs3[j]), Float.parseFloat(rs3[j + 1]), Float.parseFloat(rs3[j + 2]));
                    if(Float.parseFloat(rs3[j + 3]) <= 90.0 && Float.parseFloat(rs3[j + 4]) <= 90.0){
                        c = new Camera(p, Float.parseFloat(rs3[j + 3]), Float.parseFloat(rs3[j + 4]));
                    }else throw  new CannotSetCameraInRoomException();
                }
                room.addCamera(c);
            }
            room.printListCamera();

            for(int i = 0; i < countCamera; i++) {
            	if(room.getCameras().get(i).checkCameraInRoom(room)) {
            		System.out.println("Camera " + (i+1) + " in Room");
            	} else {
            		System.out.println("Camera " + (i+1) + " not in Room");
            	}
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotSetCameraInRoomException e) {
            e.printStackTrace();
            return null;
        }
        return room;
    }
}