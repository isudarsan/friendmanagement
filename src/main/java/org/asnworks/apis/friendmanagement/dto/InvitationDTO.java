/**
 * 
 */
package org.asnworks.apis.friendmanagement.dto;

import java.util.List;

/**
 * @author sudambat
 */
public class InvitationDTO implements java.io.Serializable {

    private static final long serialVersionUID = -1846727325242637537L;

    private List<String> friends;

    public InvitationDTO() {
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

}
