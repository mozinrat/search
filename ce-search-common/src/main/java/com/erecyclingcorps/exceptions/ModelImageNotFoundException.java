package com.erecyclingcorps.exceptions;

public class ModelImageNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	
    private static final String MSG ="Model Image not Found";

    public ModelImageNotFoundException() {
        super(MSG);
    }

}
