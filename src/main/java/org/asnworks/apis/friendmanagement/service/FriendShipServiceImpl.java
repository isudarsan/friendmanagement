/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.asnworks.apis.friendmanagement.domain.Friend;
import org.asnworks.apis.friendmanagement.dto.InvitationDTO;
import org.asnworks.apis.friendmanagement.repo.BlockRepository;
import org.asnworks.apis.friendmanagement.repo.FirendShipRepository;
import org.asnworks.apis.friendmanagement.repo.UserProfileRepository;
import org.asnworks.apis.friendmanagement.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sudambat
 */
@Service
public class FriendShipServiceImpl implements FriendShipService {

    @Autowired
    FirendShipRepository friendShiprepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    BlockRepository blockRepository;

    @Autowired
    ValidationUtils validationUtils;

    /*
     * (non-Javadoc)
     * @see
     * org.asnworks.apis.friendmanagement.service.FriendShipService#createFriendship(org.asnworks.apis.friendmanagement.domain.Invitation)
     */
    @Override
    public void createFriendship(final InvitationDTO invitationDTO) {
        friendShiprepository.save(createFriend(invitationDTO));
    }

    /*
     * (non-Javadoc)
     * @see org.asnworks.apis.friendmanagement.service.FriendShipService#getFriends(java.lang.String)
     */
    @Override
    public List<String> getFriends(final String email) {

        if (null == email) {
            // throw new WrongRequestFormatException("Must have field 'email'");
        }
        validationUtils.validatePerson(email);
        return friendShiprepository.fetchFriends(email);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.asnworks.apis.friendmanagement.service.FriendShipService#getCommonFriends(org.asnworks.apis.friendmanagement.dto.InvitationDTO)
     */
    @Override
    public List<String> getCommonFriends(InvitationDTO invitationDTO) {

        if (null == invitationDTO.getFriends() || invitationDTO.getFriends().size() != 2) {
            // throw new WrongRequestFormatException("Must have field 'friends' with length of exactly 2");
        }

        return getCommonFriends(invitationDTO.getFriends().get(0), invitationDTO.getFriends().get(1));
    }

    /**
     * @param invitationDTO
     * @return
     */
    private Friend createFriend(final InvitationDTO invitationDTO) {
        if (invitationDTO.getFriends() != null || invitationDTO.getFriends().size() != 2) {
            // throw error Must have field 'friends' with length of exactly 2
        }

        String personOne = invitationDTO.getFriends().get(0);
        String personTwo = invitationDTO.getFriends().get(1);

        validationUtils.validateFriendShipCriteria(personOne, personTwo);

        List<String> personOneFriends = friendShiprepository.fetchFriends(personOne);

        if (checkBothAreAlreadyFriends(personOneFriends, personTwo)) {
            System.out.println("asdsadsadsad");
            // throw already friend exception
        }

        List<String> blockersForPersonOne = blockRepository.fetchBlockers(personOne);
        if (blockersForPersonOne.contains(personTwo)) {
            // throw new UserBlockedException(personTwo, personOne);
        }

        List<String> blockersForPersonTwo = blockRepository.fetchBlockers(personTwo);
        if (blockersForPersonTwo.contains(personOne)) {
            // throw new UserBlockedException(personOne, personTwo);
        }

        return new Friend(personOne, personTwo);
    }

    /**
     * @param personOneFriends
     * @param personTwo
     * @return
     */
    public boolean checkBothAreAlreadyFriends(List<String> personOneFriends, String personTwo) {
        return personOneFriends.contains(personTwo) ? true : false;
    }

    private List<String> getCommonFriends(final String personOne, final String personTwo) {

        List<String> commonFriends = new ArrayList<String>();
        validationUtils.validateFriendShipCriteria(personOne, personTwo);

        List<String> personOneFriends = friendShiprepository.fetchFriends(personOne);
        List<String> personTwoFriends = friendShiprepository.fetchFriends(personTwo);

        for (String person : personOneFriends) {
            if (personTwoFriends.contains(person)) {
                commonFriends.add(person);
            }
        }

        return commonFriends;

    }

}
