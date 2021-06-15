package hu.ak_akademia.exceptiondemo;

public class ContainsSpaceRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContainsSpaceRuntimeException() {
		super();
	}

	public ContainsSpaceRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ContainsSpaceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContainsSpaceRuntimeException(String message) {
		super(message);
	}

	public ContainsSpaceRuntimeException(Throwable cause) {
		super(cause);
	}

}
