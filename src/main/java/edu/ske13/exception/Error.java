package edu.ske13.exception;

/**
 * @author kamontat
 * @version 1.0
 * @since Sun 05/Nov/2017 - 18:47
 */
public enum Error {
    ValidateException("invalid input", 100),
    
    InvalidIPException("IP is not invalid", 200),
    
    NotImplement("this method isn't implement yet!", 999);
    
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
