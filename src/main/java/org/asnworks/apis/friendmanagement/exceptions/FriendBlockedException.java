/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;


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
        return "40002";
    }

}
