/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

import org.asnworks.apis.friendmanagement.constants.Constants;

/**
 * @author sudambat This exception occurs when the request contains duplicate invitation for friend request
 */
public class DuplicateInvitaionException extends BaseException {

    private static final long serialVersionUID = -3566601960277815766L;

    public DuplicateInvitaionException(String message) {
        super(message);
    }

    public DuplicateInvitaionException(String personOne, String personTwo) {
        super("Invalid invitation :" + personOne + " and " + personTwo + " already friends.");
    }

    @Override
    public String getExceptionErrorCode() {
        return Constants.DUPLICATE_INVITATION_ERROR_CODE;
    }

}
