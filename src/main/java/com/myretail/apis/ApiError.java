package com.myretail.apis;

/**
 * ApiError is a simple object that can represent an API error back to the caller of an API.
 */
public class ApiError {

    private final String code;
    private final String message;

    /**
     * Creates an instance of ApiError.
     *
     * @param code the code associated to the error.
     * @param message the message associated to the error.
     */
    public ApiError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() { return this.code; }

    public String getMessage() { return this.message; }

}
