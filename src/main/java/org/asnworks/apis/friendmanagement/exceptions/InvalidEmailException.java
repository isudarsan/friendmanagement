/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

import org.asnworks.apis.friendmanagement.constants.Constants;

/**
 * @author sudambat
 *
 */
public class InvalidEmailException extends BaseException {


    private static final long serialVersionUID = -7787553595462711156L;

    public InvalidEmailException(String email) {
        super("Invalid email :" + email);
    }

    @Override
    public String getExceptionErrorCode() {
        return Constants.INVALID_EMAIL_ERROR_CODE;
    }

}
