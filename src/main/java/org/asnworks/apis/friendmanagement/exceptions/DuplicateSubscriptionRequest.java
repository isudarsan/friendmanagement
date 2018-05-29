/**
 * 
 */
package org.asnworks.apis.friendmanagement.exceptions;

import org.asnworks.apis.friendmanagement.constants.Constants;

/**
 * @author sudambat This exception occurs when the request contains duplicate subscription details
 */
public class DuplicateSubscriptionRequest extends BaseException {


    private static final long serialVersionUID = -3342487909681068263L;

    public DuplicateSubscriptionRequest(String requestor, String target) {
        super(" This person : " + requestor + " already subscribed for : " + target);
    }

    @Override
    public String getExceptionErrorCode() {
        return Constants.DUPLICATE_SUBSCRIPTION_ERROR_CODE;
    }
}
