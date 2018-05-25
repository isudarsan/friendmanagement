/**
 * 
 */
package org.asnworks.apis.friendmanagement.rest;

import java.util.List;

import org.asnworks.apis.friendmanagement.constants.Constants;
import org.asnworks.apis.friendmanagement.dto.ApiResponseDTO;
import org.asnworks.apis.friendmanagement.dto.EmailDTO;
import org.asnworks.apis.friendmanagement.dto.ExceptionResponseDTO;
import org.asnworks.apis.friendmanagement.dto.FriendsResponseDTO;
import org.asnworks.apis.friendmanagement.dto.InvitationDTO;
import org.asnworks.apis.friendmanagement.dto.ReciveUpdateDTO;
import org.asnworks.apis.friendmanagement.dto.ReciveUpdateResponseDTO;
import org.asnworks.apis.friendmanagement.dto.SuccessResponseDTO;
import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;
import org.asnworks.apis.friendmanagement.exceptions.BaseException;
import org.asnworks.apis.friendmanagement.service.BlockService;
import org.asnworks.apis.friendmanagement.service.FriendShipService;
import org.asnworks.apis.friendmanagement.service.SubscriptionService;
import org.asnworks.apis.friendmanagement.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(FriendsManagementController.class);

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
        try {
            LOG.info("Start :: createFriendShip :: {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
            friendShipService.createFriendship(invitationDTO);
        } catch (BaseException baseException) {
            LOG.info("Base Exception :: createFriendShip :: {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
            return new ExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
        } catch (Exception exception) {
            LOG.error("Exception :: createFriendShip :: {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
            return new ExceptionResponseDTO(Constants.UNKNOWN_ERROR_CODE, Constants.UNKNOWN_ERROR_MESSAGE);
        }
        LOG.info("End :: createFriendShip :: {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
        return new SuccessResponseDTO();
    }

    @PostMapping("/friends")
    public ApiResponseDTO getFriends(@RequestBody EmailDTO emailDTO) {
        List<String> friendsList = null;
        try {
            LOG.info("Start :: getFriends :: {}", emailDTO.getEmail());
            friendsList = friendShipService.getFriends(emailDTO.getEmail());
            LOG.info("End :: getFriends :: {}", emailDTO.getEmail());
        } catch (BaseException baseException) {
            LOG.info("Base Exception :: getFriends :: {}", emailDTO.getEmail());
            return new ExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
        } catch (Exception exception) {
            LOG.error("Exception :: getFriends :: {}", emailDTO.getEmail());
            return new ExceptionResponseDTO(Constants.UNKNOWN_ERROR_CODE, Constants.UNKNOWN_ERROR_MESSAGE);
        }

        return new FriendsResponseDTO(friendsList);
    }

    @PostMapping("/commonfriends")
    public ApiResponseDTO getCommonFriends(@RequestBody InvitationDTO invitationDTO) {
        List<String> commonFriendsList = null;
        try {
            LOG.info("Start :: getCommonFriends :: {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
            commonFriendsList = friendShipService.getCommonFriends(invitationDTO);
            LOG.info("End :: getCommonFriends :: {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
        } catch (BaseException baseException) {
            LOG.info("Base Exception :: getCommonFriends :: {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
            return new ExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
        } catch (Exception exception) {
            LOG.error("Exception :: getCommonFriends :: {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
            return new ExceptionResponseDTO(Constants.UNKNOWN_ERROR_CODE, Constants.UNKNOWN_ERROR_MESSAGE);
        }

        return new FriendsResponseDTO(commonFriendsList);
    }

    @PostMapping("/subscribe")
    public ApiResponseDTO subscribe(@RequestBody ToggleSubscriptionDTO toggleSubscriptionDTO) {

        try {
            LOG.info("Start :: subscribe :: {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
            subscriptionService.scubscribe(toggleSubscriptionDTO);
            LOG.info("End :: subscribe :: {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
        } catch (BaseException baseException) {
            LOG.info("Base Exception :: subscribe :: {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
            return new ExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
        } catch (Exception exception) {
            LOG.error("Exception :: subscribe :: {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
            return new ExceptionResponseDTO(Constants.UNKNOWN_ERROR_CODE, Constants.UNKNOWN_ERROR_MESSAGE);
        }

        return new SuccessResponseDTO();
    }

    @PostMapping("/block")
    public ApiResponseDTO block(@RequestBody ToggleSubscriptionDTO toggleSubscriptionDTO) {

        try {
            LOG.info("Start :: block :: {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
            blockService.block(toggleSubscriptionDTO);
            LOG.info("End :: block :: {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
        } catch (BaseException baseException) {
            LOG.info("Base Exception :: block :: {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
            return new ExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
        } catch (Exception exception) {
            LOG.error("Exception :: block :: {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
            return new ExceptionResponseDTO(Constants.UNKNOWN_ERROR_CODE, Constants.UNKNOWN_ERROR_MESSAGE);
        }

        return new SuccessResponseDTO();
    }

    @PostMapping("/sendupdates")
    public ApiResponseDTO postUpdates(@RequestBody ReciveUpdateDTO reciveUpdateDTO) {
        List<String> recipentList = null;
        try {
            LOG.info("Start :: postUpdates :: {} {}", reciveUpdateDTO.getSender(), reciveUpdateDTO.getText());
            recipentList = friendShipService.getUpdate(reciveUpdateDTO);
            LOG.info("End :: postUpdates :: {} {}", reciveUpdateDTO.getSender(), reciveUpdateDTO.getText());
        } catch (BaseException baseException) {
            LOG.info("BaseException :: postUpdates :: {} {}", reciveUpdateDTO.getSender(), reciveUpdateDTO.getText());
            return new ExceptionResponseDTO(baseException.getExceptionErrorCode(), baseException.getMessage());
        } catch (Exception exception) {
            LOG.info("Exception :: postUpdates :: {} {}", reciveUpdateDTO.getSender(), reciveUpdateDTO.getText());
            return new ExceptionResponseDTO(Constants.UNKNOWN_ERROR_CODE, Constants.UNKNOWN_ERROR_MESSAGE);
        }
        return new ReciveUpdateResponseDTO(recipentList);
    }

}
