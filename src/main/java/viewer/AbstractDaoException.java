package viewer;

public abstract class AbstractDaoException extends RuntimeException {

	private static final long serialVersionUID = -5315245452180035979L;

	public AbstractDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractDaoException(String message) {
		super(message);
	}

	public AbstractDaoException(Throwable cause) {
		super(cause);
	}

	
}
