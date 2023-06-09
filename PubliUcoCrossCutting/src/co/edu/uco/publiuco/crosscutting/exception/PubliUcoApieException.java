package co.edu.uco.publiuco.crosscutting.exception;

public final class PubliUcoApieException extends PubliUcoException {

	private static final long serialVersionUID = -4228650668023637895L;

	private PubliUcoApieException(String technicalMessage, String userMessage, Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.API);
	}

	public static PubliUcoApieException create(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		return new PubliUcoApieException(technicalMessage, userMessage, rootCause);
	}
	
	public static PubliUcoApieException create(final String userMessage) {
		return new PubliUcoApieException(userMessage, userMessage, new Exception());
	}
	
	public static PubliUcoApieException create(final String technicalMessage, final String userMessage) {
		return new PubliUcoApieException(technicalMessage, userMessage, new Exception());
	}
	
}
