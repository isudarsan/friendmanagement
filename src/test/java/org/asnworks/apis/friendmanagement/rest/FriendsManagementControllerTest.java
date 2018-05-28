package org.asnworks.apis.friendmanagement.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.asnworks.apis.friendmanagement.dto.ApiResponseDTO;
import org.asnworks.apis.friendmanagement.dto.EmailDTO;
import org.asnworks.apis.friendmanagement.dto.ReciveUpdateDTO;
import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;
import org.asnworks.apis.friendmanagement.service.BlockServiceImpl;
import org.asnworks.apis.friendmanagement.service.FriendShipServiceImpl;
import org.asnworks.apis.friendmanagement.service.SubscriptionServiceImpl;
import org.asnworks.apis.friendmanagement.service.UserProfileServiceImpl;
import org.junit.Test;

/**
 * @author sudambat
 */
public class FriendsManagementControllerTest {

    @Test
    public void testFriendsManagementController()
        throws Exception {
        FriendsManagementController result = new FriendsManagementController();
        assertNotNull(result);
    }

    @Test
    public void testBlock()
        throws Exception {
        FriendsManagementController fixture = new FriendsManagementController();
        fixture.subscriptionService = new SubscriptionServiceImpl();
        fixture.blockService = new BlockServiceImpl();
        fixture.friendShipService = new FriendShipServiceImpl();
        fixture.userProfileService = new UserProfileServiceImpl();
        ToggleSubscriptionDTO toggleSubscriptionDTO = new ToggleSubscriptionDTO();
        toggleSubscriptionDTO.setTarget("abc@gmail.com");
        toggleSubscriptionDTO.setRequestor("pqr@gmail.com");

        ApiResponseDTO result = fixture.block(toggleSubscriptionDTO);

        assertNotNull(result);
        assertEquals(false, result.isSuccess());
    }

    @Test
    public void testGetFriends()
        throws Exception {
        FriendsManagementController controller = new FriendsManagementController();
        controller.subscriptionService = new SubscriptionServiceImpl();
        controller.blockService = new BlockServiceImpl();
        controller.friendShipService = new FriendShipServiceImpl();
        controller.userProfileService = new UserProfileServiceImpl();
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setEmail("abc@gmail.com");

        ApiResponseDTO result = controller.getFriends(emailDTO);

        assertNotNull(result);
        assertEquals(false, result.isSuccess());
    }

    @Test
    public void testPostUpdates()
        throws Exception {
        FriendsManagementController controller = new FriendsManagementController();
        controller.subscriptionService = new SubscriptionServiceImpl();
        controller.blockService = new BlockServiceImpl();
        controller.friendShipService = new FriendShipServiceImpl();
        controller.userProfileService = new UserProfileServiceImpl();
        ReciveUpdateDTO reciveUpdateDTO = new ReciveUpdateDTO();
        reciveUpdateDTO.setSender("abc@gmail.com");
        reciveUpdateDTO.setText("Hello, How are you pqr@gmail.com");
        ApiResponseDTO result = controller.postUpdates(reciveUpdateDTO);
        assertNotNull(result);
        assertEquals(false, result.isSuccess());
    }

    @Test
    public void testSubscribe()
        throws Exception {
        FriendsManagementController controller = new FriendsManagementController();
        controller.subscriptionService = new SubscriptionServiceImpl();
        controller.blockService = new BlockServiceImpl();
        controller.friendShipService = new FriendShipServiceImpl();
        controller.userProfileService = new UserProfileServiceImpl();
        ToggleSubscriptionDTO toggleSubscriptionDTO = new ToggleSubscriptionDTO();
        toggleSubscriptionDTO.setTarget("abc@gmail.com");
        toggleSubscriptionDTO.setRequestor("pqr@gmail.com");

        ApiResponseDTO result = controller.subscribe(toggleSubscriptionDTO);

        assertNotNull(result);
        assertEquals(false, result.isSuccess());
    }

    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(FriendsManagementControllerTest.class);
    }
}