/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

import org.asnworks.apis.friendmanagement.constants.Constants;

/**
 * @author sudambat This exception occurs when the request contains invalid data
 */
public class InvalidRequestException extends BaseException {

    private static final long serialVersionUID = -4058741024665851134L;

    public InvalidRequestException(String message) {
        super("Invalid Request : " + message);
    }

    @Override
    public String getExceptionErrorCode() {
        return Constants.INVALID_REQUEST_ERROR_CODE;
    }


}
