package aod.task.staff.exception;

/**
 * class for throw exception when not found member
 * 
 * @author vahagn
 *
 */
public class NotMemberFoundException extends RuntimeException {

	private static final long serialVersionUID = 1369090163542611817L;

	/**
	 * call super default constructor
	 */
	public NotMemberFoundException() {
		super();
	}

	/**
	 * call super constructor with parameter
	 * 
	 * @param message
	 */
	public NotMemberFoundException(String message) {
		super(message);
	}

}
