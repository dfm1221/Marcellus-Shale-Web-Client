package viewer;

public class InvalidDaoInputException extends AbstractDaoException {

	private static final long serialVersionUID = -2561951126840094068L;

	public InvalidDaoInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDaoInputException(String message) {
		super(message);
	}

	public InvalidDaoInputException(Throwable cause) {
		super(cause);
	}

	
}
