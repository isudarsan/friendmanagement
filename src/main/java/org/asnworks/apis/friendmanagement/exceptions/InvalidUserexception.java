/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;


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
        return "40004";
    }

}
