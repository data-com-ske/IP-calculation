package edu.ske13.exception;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 05/Nov/2017 - 18:47
 */
public enum Error {
    ValidateException("invalid input", 100),
    
    InvalidIPException("IP is not invalid", 200),
    
    IPClassNotFound("IP class not found", 404),
    
    NotImplement("this method isn't implement yet!", 999),
    
    UnknownError("don't have any error message", 998);
    
    private String title;
    private int code;
    
    Error(String title, int code) {
        this.title = title;
        this.code = code;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getCode() {
        return code;
    }
    
    @Override
    public String toString() {
        return "Error{" + "title='" + title + '\'' + ", code=" + code + '}';
    }
}
