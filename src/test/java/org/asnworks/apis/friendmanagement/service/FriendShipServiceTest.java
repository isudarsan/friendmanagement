/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.asnworks.apis.friendmanagement.dto.InvitationDTO;
import org.asnworks.apis.friendmanagement.dto.ReciveUpdateDTO;
import org.junit.Test;

/**
 * @author sudambat
 */
public class FriendShipServiceTest {

    @Test
    public void testGetFriends() {
        FriendShipServiceImpl mockFriendShipService = mock(FriendShipServiceImpl.class);
        List<String> friendsList = Arrays.asList(new String[] {"abc@gmail.com", "xyz@gmail.com"});
        when(mockFriendShipService.getFriends("def@gmail.com")).thenReturn(friendsList);
    }

    @Test
    public void testCreateFriendShip() {
        FriendShipServiceImpl mockFriendShipService = mock(FriendShipServiceImpl.class);
        final InvitationDTO invitationDTO = new InvitationDTO();
        doNothing().when(mockFriendShipService).createFriendship(invitationDTO);
    }

    @Test
    public void testGetCommonFriends() {
        List<String> friendsList = Arrays.asList(new String[] {"abc@gmail.com", "xyz@gmail.com"});
        FriendShipServiceImpl mockFriendShipService = mock(FriendShipServiceImpl.class);
        final InvitationDTO invitationDTO = new InvitationDTO();
        invitationDTO.setFriends(Arrays.asList(new String[] {"def@gmail.com", "pqr@gmail.com"}));
        when(mockFriendShipService.getCommonFriends(invitationDTO)).thenReturn(friendsList);
    }

    @Test
    public void testGetUpdates() {
        FriendShipServiceImpl mockFriendShipService = mock(FriendShipServiceImpl.class);
        final ReciveUpdateDTO reciveUpdateDTO = new ReciveUpdateDTO();
        reciveUpdateDTO.setSender("abc@gmail.com");
        reciveUpdateDTO.setText("Hello @pqr@gmail.com");
        when(mockFriendShipService.getUpdate(reciveUpdateDTO)).thenReturn(Arrays.asList(new String[] {"pqr@gmail.com", "xyz@gmail.com"}));

    }

}
