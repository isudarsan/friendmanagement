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

    /**
     * @param invitationDTO This method used to create friendship for two persons
     */
    void createFriendship(final InvitationDTO invitationDTO);

    /**
     * @param email
     * @return List of Friends for given email
     */
    List<String> getFriends(final String email);

    /**
     * @param invitationDTO
     * @return List of common friends for given two persons.
     */
    List<String> getCommonFriends(final InvitationDTO invitationDTO);

    /**
     * @param reciveUpdateDTO
     * @return List of Persons for post updates.
     */
    List<String> getUpdate(final ReciveUpdateDTO reciveUpdateDTO);
}
