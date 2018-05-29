/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

/**
 * @author sudambat Base Exception for the Application
 */
public abstract class BaseException extends RuntimeException {


    private static final long serialVersionUID = -272761610295470586L;

    public BaseException(String message) {
        super(message);
    }

    public abstract String getExceptionErrorCode();

}
