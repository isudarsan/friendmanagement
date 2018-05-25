/**
 * 
 */
package org.asnworks.apis.friendmanagement.dto;

/**
 * @author sudambat
 */
public class ToggleSubscriptionDTO {

    private String requestor;
    private String target;

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
