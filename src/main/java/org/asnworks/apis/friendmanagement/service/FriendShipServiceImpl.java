/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.asnworks.apis.friendmanagement.domain.Friend;
import org.asnworks.apis.friendmanagement.dto.InvitationDTO;
import org.asnworks.apis.friendmanagement.dto.ReciveUpdateDTO;
import org.asnworks.apis.friendmanagement.exceptions.DuplicateInvitaionException;
import org.asnworks.apis.friendmanagement.exceptions.FriendBlockedException;
import org.asnworks.apis.friendmanagement.exceptions.InvalidRequestException;
import org.asnworks.apis.friendmanagement.repo.BlockRepository;
import org.asnworks.apis.friendmanagement.repo.FirendShipRepository;
import org.asnworks.apis.friendmanagement.repo.SubscribeRepository;
import org.asnworks.apis.friendmanagement.repo.UserProfileRepository;
import org.asnworks.apis.friendmanagement.utils.ValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sudambat
 */
@Service
public class FriendShipServiceImpl implements FriendShipService {

    private static final Logger LOG = LoggerFactory.getLogger(FriendShipServiceImpl.class);

    @Autowired
    FirendShipRepository friendShiprepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    BlockRepository blockRepository;

    @Autowired
    SubscribeRepository subscribeRepository;

    @Autowired
    ValidationUtils validationUtils;

    /*
     * (non-Javadoc)
     * @see
     * org.asnworks.apis.friendmanagement.service.FriendShipService#createFriendship(org.asnworks.apis.friendmanagement.domain.Invitation)
     */
    @Override
    public void createFriendship(final InvitationDTO invitationDTO) {
        LOG.info("Start :: createFriendship {} {} ", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
        friendShiprepository.save(createFriend(invitationDTO));
        LOG.info("End :: createFriendship {} {} ", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
    }

    /*
     * (non-Javadoc)
     * @see org.asnworks.apis.friendmanagement.service.FriendShipService#getFriends(java.lang.String)
     */
    @Override
    public List<String> getFriends(final String email) {
        LOG.info("Start :: getFriends {} ", email);
        if (null == email) {
            LOG.info("InvalidRequestException :: getFriends {} ", email);
            throw new InvalidRequestException("Request doesnt contains email");
        }
        validationUtils.validatePerson(email);
        List<String> friends = friendShiprepository.fetchFriends(email);

        LOG.info("End :: getFriends {} ", email);
        return friends;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.asnworks.apis.friendmanagement.service.FriendShipService#getCommonFriends(org.asnworks.apis.friendmanagement.dto.InvitationDTO)
     */
    @Override
    public List<String> getCommonFriends(InvitationDTO invitationDTO) {
        LOG.info("Start :: getCommonFriends {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
        if (null == invitationDTO.getFriends() || invitationDTO.getFriends().size() != 2) {
            LOG.info("InvalidRequestException :: getCommonFriends {} {}", invitationDTO.getFriends().get(0),
                invitationDTO.getFriends().get(1));
            throw new InvalidRequestException("Request doesnt contains friends or size of friends are not two");
        }
        List<String> commonFriends = getCommonFriends(invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
        LOG.info("End :: getCommonFriends {} {}", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
        return commonFriends;
    }

    /*
     * (non-Javadoc)
     * @see org.asnworks.apis.friendmanagement.service.FriendShipService#getUpdate(org.asnworks.apis.friendmanagement.dto.ReciveUpdateDTO)
     */
    @Override
    public List<String> getUpdate(ReciveUpdateDTO reciveUpdateDTO) {
        LOG.info("Start :: getUpdate {} {}", reciveUpdateDTO.getSender(), reciveUpdateDTO.getText());
        if (null == reciveUpdateDTO.getSender() || null == reciveUpdateDTO.getText()) {
            LOG.info("InvalidRequestException :: getUpdate {} {}", reciveUpdateDTO.getSender(), reciveUpdateDTO.getText());
            throw new InvalidRequestException("Invalid request : Request doesnt contains sender or text or null");
        }

        validationUtils.validatePerson(reciveUpdateDTO.getSender());

        List<String> senderFriends = friendShiprepository.fetchFriends(reciveUpdateDTO.getSender());
        List<String> senderSubscribers = subscribeRepository.fetchSubscribers(reciveUpdateDTO.getSender());
        List<String> senderBlockers = blockRepository.fetchBlockers(reciveUpdateDTO.getSender());
        List<String> extractedMailsFromSenderText = extractMailsFromSenderText(reciveUpdateDTO.getText());

        List<String> recipentsList =
            buildRecipients(reciveUpdateDTO.getSender(), senderFriends, senderSubscribers, senderBlockers, extractedMailsFromSenderText);

        LOG.info("End :: getUpdate {} {}", reciveUpdateDTO.getSender(), reciveUpdateDTO.getText());
        return recipentsList;

    }

    /**
     * @param invitationDTO
     * @return
     */
    private Friend createFriend(final InvitationDTO invitationDTO) {
        LOG.info("Start :: createFriend {} {} ", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
        if (null == invitationDTO.getFriends() || invitationDTO.getFriends().size() != 2) {
            LOG.info("InvalidRequestException :: createFriend {} {} ", invitationDTO.getFriends().get(0),
                invitationDTO.getFriends().get(1));
            throw new InvalidRequestException("Request doesnt contains friends or size of friends are not two");
        }

        String personOne = invitationDTO.getFriends().get(0);
        String personTwo = invitationDTO.getFriends().get(1);

        validationUtils.validateFriendShipCriteria(personOne, personTwo);

        List<String> personOneFriends = friendShiprepository.fetchFriends(personOne);

        if (checkBothAreAlreadyFriends(personOneFriends, personTwo)) {
            LOG.info("DuplicateInvitaionException :: createFriend {} {} ", invitationDTO.getFriends().get(0),
                invitationDTO.getFriends().get(1));
            throw new DuplicateInvitaionException(personOne, personTwo);
        }

        List<String> blockersForPersonOne = blockRepository.fetchBlockers(personOne);
        if (blockersForPersonOne.contains(personTwo)) {
            LOG.info("FriendBlockedException :: createFriend {} {} ", invitationDTO.getFriends().get(0),
                invitationDTO.getFriends().get(1));
            throw new FriendBlockedException(personOne, personTwo);
        }

        List<String> blockersForPersonTwo = blockRepository.fetchBlockers(personTwo);
        if (blockersForPersonTwo.contains(personOne)) {
            LOG.info("FriendBlockedException :: createFriend {} {} ", invitationDTO.getFriends().get(0),
                invitationDTO.getFriends().get(1));
            throw new FriendBlockedException(personOne, personTwo);
        }

        LOG.info("End :: createFriend {} {} ", invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
        return new Friend(personOne, personTwo);
    }

    /**
     * @param personOneFriends
     * @param personTwo
     * @return
     */
    public boolean checkBothAreAlreadyFriends(final List<String> personOneFriends, final String personTwo) {
        return personOneFriends.contains(personTwo) ? true : false;
    }

    private List<String> getCommonFriends(final String personOne, final String personTwo) {
        LOG.info("Start :: getCommonFriends {} {} ", personOne, personTwo);
        List<String> commonFriends = new ArrayList<String>();
        validationUtils.validateFriendShipCriteria(personOne, personTwo);

        List<String> personOneFriends = friendShiprepository.fetchFriends(personOne);
        List<String> personTwoFriends = friendShiprepository.fetchFriends(personTwo);

        for (String person : personOneFriends) {
            if (personTwoFriends.contains(person)) {
                commonFriends.add(person);
            }
        }
        LOG.info("End :: getCommonFriends {} {} ", personOne, personTwo);
        return commonFriends;

    }

    /**
     * @param sender
     * @param senderFriends
     * @param senderSubscribers
     * @param senderBlockers
     * @param extractedMailsFromSenderText
     * @return
     */
    private List<String> buildRecipients(final String sender, final List<String> senderFriends, final List<String> senderSubscribers,
        final List<String> senderBlockers, final List<String> extractedMailsFromSenderText) {
        LOG.info("Start :: buildRecipients {}", sender);
        Set<String> setOfRecipents = new HashSet<>();

        setOfRecipents.addAll(senderFriends);
        setOfRecipents.addAll(senderSubscribers);
        setOfRecipents.addAll(extractedMailsFromSenderText);
        setOfRecipents.removeAll(senderBlockers);
        setOfRecipents.remove(sender);

        List<String> recipents = new ArrayList<String>(setOfRecipents);
        LOG.info("End :: buildRecipients {}", sender);
        return recipents;
    }

    /**
     * @param text
     * @return
     */
    private List<String> extractMailsFromSenderText(final String text) {
        LOG.info("Start :: extractMailsFromSenderText {}", text);
        List<String> emailsInText = new ArrayList<String>();
        List<String> extractedEmails = validationUtils.extractMailsFromText(text);
        if (null != extractedEmails) {
            for (String extractedMail : extractedEmails) {
                if (null != userProfileRepository.findById(extractedMail)) {
                    emailsInText.add(extractedMail);
                }
            }
        }
        LOG.info("End :: extractMailsFromSenderText {}", text);
        return emailsInText;
    }

}
