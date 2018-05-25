/**
 * 
 */
package org.asnworks.apis.friendmanagement.dto;

import java.util.List;

/**
 * @author sudambat
 */
public class FriendsResponseDTO extends ApiResponseDTO {

    private List<String> friends;
    private int count;

    public FriendsResponseDTO(List<String> friends) {
        super(true);
        this.friends = friends;
        this.count = friends.size();
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
