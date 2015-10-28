package com.myretail.apis;

/**
 * ObjectNotFoundException is a simple type safe "marker" type generic exception that can be used to indicate that an
 * object of any type was not found.
 */
public class ObjectNotFoundException extends RuntimeException {

    /**
     * Creates an instance of ObjectNotFoundException.
     *
     * @param message a message to be associated to the exception.
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }

}
