package readFile;

import point.CameraPoint;
import point.ListCameras;
import point.Point;
import spaceFigure.Entity;

import spaceFigure.GroupOfEntity;
import spaceFigure.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Test {

    public static void main(String[] args) {
        BufferedReader br = null;
        Room room = new Room();
        Entity entity = new Entity();
        GroupOfEntity entities = new GroupOfEntity();
        ListCameras listCameras = new ListCameras();
        String lineRoomPoints;
        String lineEntityPoints;
        String lineCamera;
        StringSplit stringSplit = new StringSplit();
        try {
            br = new BufferedReader(new FileReader("F:\\input.txt"));
            // dòng 1 tọa độ 4 diểm ABCD A'B'C'D'
            lineRoomPoints = br.readLine();
            String[] rs1 = stringSplit.deleteAndSplit(lineRoomPoints);
            for (int i = 0; i < rs1.length; i += 3) {
                room.addPoint(new Point(Double.parseDouble(rs1[i]), Double.parseDouble(rs1[i + 1]), Double.parseDouble(rs1[i + 2])));
            }
            room.printPointsList();

            int countEntity = Integer.parseInt(br.readLine());// số vật thể trong phòng
            System.out.println(" " + countEntity);
            for (int i = 0; i < countEntity; i++) {
                lineEntityPoints = br.readLine();
                String[] rs2 = stringSplit.deleteAndSplit(lineEntityPoints);
                for (int j = 0; j < rs2.length; j += 3) {
                    entity.addPoint(new Point(Double.parseDouble(rs2[i]), Double.parseDouble(rs2[i + 1]),
                            Double.parseDouble(rs2[i + 2])));
                }
                entities.addEntities(entity);
            }
            entities.printListEntities();
            //đọc camera
            int countCamera = Integer.parseInt(br.readLine());
            System.out.println(" " + countCamera);
            for (int i = 0; i < countCamera; i++) {
                lineCamera = br.readLine();
                String[] rs3 = stringSplit.deleteAndSplit(lineCamera);
                int j = 0;
                Point p = new Point(Double.parseDouble(rs3[j++]), Double.parseDouble(rs3[j++]),
                        Double.parseDouble(rs3[j++]));
                listCameras.addCamera(new CameraPoint(p,Integer.parseInt(rs3[j++]),Integer.parseInt(rs3[j++])));
            }
            listCameras.printListCameras();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
