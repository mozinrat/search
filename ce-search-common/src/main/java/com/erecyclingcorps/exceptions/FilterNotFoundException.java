package com.erecyclingcorps.exceptions;

public class FilterNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final String MSG ="Filter applied is invalid";

    public FilterNotFoundException() {
        super(MSG);
    }

}
