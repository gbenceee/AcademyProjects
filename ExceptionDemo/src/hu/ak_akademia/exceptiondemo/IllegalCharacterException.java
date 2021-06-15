package hu.ak_akademia.exceptiondemo;

public class IllegalCharacterException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalCharacterException() {
		super();
	}

	public IllegalCharacterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalCharacterException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalCharacterException(String message) {
		super(message);
	}

	public IllegalCharacterException(Throwable cause) {
		super(cause);
	}

}
