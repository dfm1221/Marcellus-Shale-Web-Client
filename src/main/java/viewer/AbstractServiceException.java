package viewer;

public abstract class AbstractServiceException extends RuntimeException {

	private static final long serialVersionUID = 7158042686438940135L;

	public AbstractServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractServiceException(String message) {
		super(message);
	}

	public AbstractServiceException(Throwable cause) {
		super(cause);
	}

	
}
