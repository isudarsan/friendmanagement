/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import java.util.List;

import org.asnworks.apis.friendmanagement.dto.InvitationDTO;

/**
 * @author sudambat
 */
public interface FriendShipService {

    void createFriendship(final InvitationDTO invitationDTO);

    List<String> getFriends(final String email);

    List<String> getCommonFriends(final InvitationDTO invitationDTO);
}
