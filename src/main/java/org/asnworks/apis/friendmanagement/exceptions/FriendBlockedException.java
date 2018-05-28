/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

import org.asnworks.apis.friendmanagement.constants.Constants;

/**
 * @author sudambat
 *
 */
public class FriendBlockedException extends BaseException {

    private static final long serialVersionUID = 5705634452701140244L;

    public FriendBlockedException(String message) {
        super(message);
    }

    public FriendBlockedException(String personOne, String personTwo) {
        super("Friendship not possible. " + personOne + " blocked " + personTwo);
    }

    @Override
    public String getExceptionErrorCode() {
        return Constants.FRIEND_BLOCKED_ERROR_CODE;
    }

}
