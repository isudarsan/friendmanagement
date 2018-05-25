/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import java.util.List;

import org.asnworks.apis.friendmanagement.dto.InvitationDTO;
import org.asnworks.apis.friendmanagement.dto.ReciveUpdateDTO;

/**
 * @author sudambat
 */
public interface FriendShipService {

    void createFriendship(final InvitationDTO invitationDTO);

    List<String> getFriends(final String email);

    List<String> getCommonFriends(final InvitationDTO invitationDTO);

    List<String> getUpdate(final ReciveUpdateDTO reciveUpdateDTO);
}
