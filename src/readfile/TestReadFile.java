package readfile;

import Camera.Camera;
import Coordinates.Point;
import spaceFigure.Entity;
import spaceFigure.Rectangular;
import spaceFigure.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
    public static void main(String[] args) {
        Room room = new Room();
        int countEntity, countCamera;

        StringSplit stringSplit = new StringSplit();

        try (BufferedReader br = new BufferedReader(new FileReader("src/readfile/input.txt"))) {
            // dia chi toi file
        	
            // dong 1 toa do 4 diem A, B, C, D
            String lineRoom = br.readLine();
            String[] rs1 = stringSplit.deleteAndSplit(lineRoom);
            for (int i = 0; i < rs1.length; i += 3) {
                Point p = new Point(Float.parseFloat(rs1[i]), Float.parseFloat(rs1[i + 1]), Float.parseFloat(rs1[i + 2]));
                room.addPoint(p);
            }
            // room
            // check phai hhcn hay khong
            room.printListPoint();

            countEntity = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < countEntity; i++) {
                String lineEntity = br.readLine();
                String[] rs2 = stringSplit.deleteAndSplit(lineEntity);
                Entity entity = new Entity();
                for (int j = 0; j < rs2.length; j += 3) {
                    Point p = new Point(Float.parseFloat(rs2[j]), Float.parseFloat(rs2[j + 1]), Float.parseFloat(rs2[j + 2]));
                    entity.addPoint(p);
                }
                room.addEntity(entity);
            }
            room.printListEntities();

            countCamera = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < countCamera; i++) {
                String lineCamera = br.readLine();
                String[] rs3 = stringSplit.deleteAndSplit(lineCamera);
                Camera c = new Camera();
                for (int j = 0; j < rs3.length; j += 5) {
                    Point p = new Point(Float.parseFloat(rs3[j]), Float.parseFloat(rs3[j + 1]), Float.parseFloat(rs3[j + 2]));
                    c = new Camera(p, Integer.parseInt(rs3[j + 3]), Integer.parseInt(rs3[j + 4]));
                }
                room.addCamera(c);
            }
            room.printListCamera();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
