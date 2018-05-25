/**
 * 
 */
package org.asnworks.apis.friendmanagement.utils;

import org.asnworks.apis.friendmanagement.repo.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sudambat
 */
@Component
public class ValidationUtils {

    @Autowired
    UserProfileRepository userProfileRepository;

    /**
     * @param personOne
     * @param personTwo
     */
    public void validateFriendShipCriteria(final String personOne, final String personTwo) {
        validatePerson(personOne);
        validatePerson(personTwo);

        if (personOne.equalsIgnoreCase(personTwo)) {
            // throw exception saying same users can not be friends
        }
    }

    /**
     * @param person
     */
    public void validatePerson(final String person) {
        if (userProfileRepository.findById(person) == null) {
            // throw user not found
        }
    }
}
