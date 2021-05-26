package Camera;

import spaceFigure.Room;

import java.util.List;

public class CheckCamera {
    public boolean checkCameraExists(Room room, Camera camera){
        List<Camera> cameraList = room.getCameras();
        if(!cameraList.isEmpty()){
            for (Camera c : cameraList){
                if(c.getPosition().checkPointExists(camera.getPosition())){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAngle(float angle){
        return (angle > 0 && angle <= 90.0) ? true : false;
    }

}
