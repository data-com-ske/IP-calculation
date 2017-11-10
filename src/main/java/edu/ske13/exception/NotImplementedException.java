package edu.ske13.exception;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Nov/2017 - 19:49
 */
public class NotImplementedException extends RuntimeIPException {
    public NotImplementedException() {
        this(Error.NotImplement);
    }
    
    public NotImplementedException(Error error, Throwable cause) {
        super(Error.NotImplement, cause);
    }
    
    private NotImplementedException(Error error) {
        super(Error.NotImplement);
    }
}
