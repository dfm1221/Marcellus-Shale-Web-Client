package viewer;

public class InvalidServiceInputException extends AbstractServiceException {

	private static final long serialVersionUID = -627302544530693030L;

	public InvalidServiceInputException(String message) {
		super(message);
	}

	public InvalidServiceInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidServiceInputException(Throwable cause) {
		super(cause);
	}

	
}
