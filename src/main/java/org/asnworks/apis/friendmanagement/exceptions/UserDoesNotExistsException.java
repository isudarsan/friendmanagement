/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;


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
        return "40005";
    }

}
