package org.asnworks.apis.friendmanagement.service;

import org.asnworks.apis.friendmanagement.domain.UserProfile;
import org.asnworks.apis.friendmanagement.dto.EmailDTO;
import org.asnworks.apis.friendmanagement.repo.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    /*
     * (non-Javadoc)
     * @see org.asnworks.apis.friendmanagement.service.UserProfileService#signUp(org.asnworks.apis.friendmanagement.domain.UserProfile)
     */
    @Override
    public UserProfile signUp(final EmailDTO emailDTO) {
        return userProfileRepository.save(createUserProfile(emailDTO.getEmail()));
    }

    /**
     * @param email
     * @return
     */
    private UserProfile createUserProfile(final String email) {
        return new UserProfile(email);
    }

}
