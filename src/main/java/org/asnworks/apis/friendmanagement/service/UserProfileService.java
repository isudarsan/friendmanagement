/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import org.asnworks.apis.friendmanagement.domain.UserProfile;
import org.asnworks.apis.friendmanagement.dto.EmailDTO;

/**
 * @author sudambat
 *
 */
public interface UserProfileService {

    /**
     * @param emailDTO
     * @return UserProfile
     */
    UserProfile signUp(final EmailDTO emailDTO);


}
