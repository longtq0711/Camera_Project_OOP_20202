package point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCameras {
    private List<CameraPoint> cameras = new ArrayList<>();
    private int count = 0;

    public void addCamera(CameraPoint cameraPoint){
        addCamera(cameraPoint);
        count++;
    }

    public void printListCameras(){
        Iterator i = cameras.iterator();
        String rs = "";
        while (i.hasNext()){
            CameraPoint cameraPoint = (CameraPoint) i.next();
            rs += " ( " + cameraPoint.getPoint().getX() + ", " +cameraPoint.getPoint().getY() + ", "
                    + cameraPoint.getPoint().getZ() + " ) " + cameraPoint.getHighAngle() +" "+cameraPoint.getWideAngle();
        }
        System.out.println("rs");
    }
}
