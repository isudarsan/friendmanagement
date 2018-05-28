/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

import org.asnworks.apis.friendmanagement.constants.Constants;

/**
 * @author sudambat
 *
 */
public class InvalidUserexception extends BaseException {


    private static final long serialVersionUID = 7502391798240175182L;

    public InvalidUserexception(String message) {
        super(message);
    }

    @Override
    public String getExceptionErrorCode() {
        return Constants.INVALID_USER_ERROR_CODE;
    }

}
