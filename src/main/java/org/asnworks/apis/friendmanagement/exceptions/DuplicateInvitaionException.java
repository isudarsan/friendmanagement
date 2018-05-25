/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;


/**
 * @author sudambat
 *
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
        return "40001";
    }

}
