/**
 * 
 */
package org.asnworks.apis.friendmanagement.rest;

import java.util.List;

import org.asnworks.apis.friendmanagement.dto.ApiResponseDTO;
import org.asnworks.apis.friendmanagement.dto.EmailDTO;
import org.asnworks.apis.friendmanagement.dto.FriendsResponseDTO;
import org.asnworks.apis.friendmanagement.dto.InvitationDTO;
import org.asnworks.apis.friendmanagement.dto.SuccessResponseDTO;
import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;
import org.asnworks.apis.friendmanagement.service.BlockService;
import org.asnworks.apis.friendmanagement.service.FriendShipService;
import org.asnworks.apis.friendmanagement.service.SubscriptionService;
import org.asnworks.apis.friendmanagement.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudambat
 */
@RestController
@RequestMapping("/firendsapi/*")
public class FriendsManagementController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    FriendShipService friendShipService;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    BlockService blockService;

    @PostMapping("/signup")
    public ApiResponseDTO signUp(@RequestBody EmailDTO emailDTO) {
        userProfileService.signUp(emailDTO);
        return new SuccessResponseDTO();
    }

    @PostMapping("/friendrequest")
    public ApiResponseDTO createFriendShip(@RequestBody InvitationDTO invitationDTO) {
        friendShipService.createFriendship(invitationDTO);
        return new SuccessResponseDTO();
    }

    @PostMapping("/subscribe")
    public ApiResponseDTO subscribe(@RequestBody ToggleSubscriptionDTO toggleSubscriptionDTO) {
        subscriptionService.scubscribe(toggleSubscriptionDTO);
        return new SuccessResponseDTO();
    }

    @PostMapping("/block")
    public ApiResponseDTO block(@RequestBody ToggleSubscriptionDTO toggleSubscriptionDTO) {
        blockService.block(toggleSubscriptionDTO);
        return new SuccessResponseDTO();
    }

    @PostMapping("/friends")
    public ApiResponseDTO getFriends(@RequestBody EmailDTO emailDTO) {
        List<String> list = friendShipService.getFriends(emailDTO.getEmail());
        return new FriendsResponseDTO(list);
    }

    @PostMapping("/commonfriends")
    public ApiResponseDTO getCommonFriends(@RequestBody InvitationDTO invitationDTO) {
        List<String> list = friendShipService.getCommonFriends(invitationDTO);
        return new FriendsResponseDTO(list);
    }


}
