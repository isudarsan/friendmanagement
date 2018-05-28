/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

import org.asnworks.apis.friendmanagement.constants.Constants;

/**
 * @author sudambat
 *
 */
public class UserDoesNotExistsException extends BaseException {

    private static final long serialVersionUID = 5570113963372118063L;

    public UserDoesNotExistsException(String message) {
        super("User does not exists : " + message);
    }

    @Override
    public String getExceptionErrorCode() {
        return Constants.USER_DOES_NOT_EXISTS_ERROR_CODE;
    }

}
