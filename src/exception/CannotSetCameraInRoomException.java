package exception;

public class CannotSetCameraInRoomException extends Exception{

    private static final long serialVersionUID = 1L;

    public CannotSetCameraInRoomException() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void printStackTrace() {
        System.out.println("Some Thing Wrong! Please Check Camera Data");
    }
}
