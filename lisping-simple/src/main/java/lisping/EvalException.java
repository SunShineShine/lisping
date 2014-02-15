package lisping;

public class EvalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EvalException(String message, Throwable cause) {
		super(message, cause);
	}

	public EvalException(String message) {
		super(message);
	}

	public EvalException(Throwable cause) {
		super(cause);
	}

}
