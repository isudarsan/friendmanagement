/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

/**
 * @author sudambat
 */
public class DuplicateSubscriptionRequest extends BaseException {


    private static final long serialVersionUID = -3342487909681068263L;

    public DuplicateSubscriptionRequest(String requestor, String target) {
        super(" This person : " + requestor + " already subscribed for : " + target);
    }

    @Override
    public String getExceptionErrorCode() {
        return "40003";
    }
}
