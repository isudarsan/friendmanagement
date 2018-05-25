/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

/**
 * @author sudambat
 */
public class InvalidRequestException extends BaseException {

    private static final long serialVersionUID = -4058741024665851134L;

    public InvalidRequestException(String message) {
        super("Invalid Request : " + message);
    }

    @Override
    public String getExceptionErrorCode() {
        return "4000";
    }


}
