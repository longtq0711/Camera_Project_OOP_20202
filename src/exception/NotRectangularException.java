package exception;

public class NotRectangularException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotRectangularException() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printStackTrace() {
		System.out.println("NotRectangularException");
	}
}
