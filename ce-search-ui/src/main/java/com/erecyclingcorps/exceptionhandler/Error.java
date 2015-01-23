package com.erecyclingcorps.exceptionhandler;


/**
 * @author parora
 *  
 **/


public class Error {

    private final String message;
    private final Exception exception; 

    /**
     * The Error class should always used with below constructor
     *
     */
    public Error(String message, Exception exception) {
        this.message=message;
        this.exception=exception;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }

}