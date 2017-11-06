package edu.ske13.exception;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 05/Nov/2017 - 18:46
 */
public class IPException extends Exception {
	/**
	 * Constructs a new exception with {@code null} as its detail message.
	 * The cause is not initialized, and may subsequently be initialized by a
	 * call to {@link #initCause}.
	 */
	public IPException() {
		super();
	}
	
	/**
	 * Constructs a new exception with the specified detail message.  The
	 * cause is not initialized, and may subsequently be initialized by
	 * a call to {@link #initCause}.
	 *
	 * @param message
	 * 		the detail message. The detail message is saved for
	 * 		later retrieval by the {@link #getMessage()} method.
	 */
	public IPException(Error error) {
		super(error.toString());
	}
	
	/**
	 * Constructs a new exception with the specified detail message and
	 * cause.  <p>Note that the detail message associated with
	 * {@code cause} is <i>not</i> automatically incorporated in
	 * this exception's detail message.
	 *
	 * @param message
	 * 		the detail message (which is saved for later retrieval
	 * 		by the {@link #getMessage()} method).
	 * @param cause
	 * 		the cause (which is saved for later retrieval by the
	 * 		{@link #getCause()} method).  (A <tt>null</tt> value is
	 * 		permitted, and indicates that the cause is nonexistent or
	 * 		unknown.)
	 * @since 1.4
	 */
	public IPException(Error error, Throwable cause) {
		super(error.toString(), cause);
	}
}
