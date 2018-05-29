/**
 * 
 */
package org.asnworks.apis.friendmanagement.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.asnworks.apis.friendmanagement.constants.Constants;
import org.asnworks.apis.friendmanagement.exceptions.InvalidEmailException;
import org.asnworks.apis.friendmanagement.exceptions.InvalidUserexception;
import org.asnworks.apis.friendmanagement.exceptions.UserDoesNotExistsException;
import org.asnworks.apis.friendmanagement.repo.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sudambat Validation utility
 */
@Component
public class ValidationUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ValidationUtils.class);

    @Autowired
    UserProfileRepository userProfileRepository;

    /**
     * @param personOne
     * @param personTwo This method validates friendship criteria.
     */
    public void validateFriendShipCriteria(final String personOne, final String personTwo) {
        LOG.info("Start :: validateFriendShipCriteria :: {} {}", personOne, personTwo);
        validatePerson(personOne);
        validatePerson(personTwo);

        if (personOne.equalsIgnoreCase(personTwo)) {
            LOG.info("InvalidUserexception :: validateFriendShipCriteria :: {} {}", personOne, personTwo);
            throw new InvalidUserexception("Invalid Request : Same users can not be friends.");
        }
        LOG.info("End :: validateFriendShipCriteria :: {} {}", personOne, personTwo);
    }

    /**
     * @param person
     */
    public void validatePerson(final String person) {
        LOG.info("Start :: validatePerson :: {}", person);
        if (!isValidEmail(person)) {
            LOG.info("InvalidEmailException :: validatePerson :: {}", person);
            throw new InvalidEmailException(person);
        }
        if (userProfileRepository.findById(person) == null) {
            LOG.info("UserDoesNotExistsException :: validatePerson :: {}", person);
            throw new UserDoesNotExistsException(person);
        }
        LOG.info("End :: validatePerson :: {}", person);
    }

    /**
     * @param email
     */
    public List<String> extractMailsFromText(final String email) {
        LOG.info("Start :: extractMailsFromText :: {}", email);
        Pattern pattern = Pattern.compile(Constants.EMAIL_REGEX_MATCHER);
        Matcher matcher = pattern.matcher(email);
        List<String> extractedEmails = new ArrayList<String>();
        while (matcher.find()) {
            extractedEmails.add(matcher.group());
        }
        LOG.info("End :: extractMailsFromText :: {}", email);
        return extractedEmails;
    }

    /**
     * @param email
     * @return boolean
     */
    public boolean isValidEmail(final String email) {
        LOG.info("Start :: isValidEmail :: {}", email);
        Pattern pattern = Pattern.compile(Constants.VALID_EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        boolean flag = matcher.matches();
        LOG.info("End :: isValidEmail :: {}", email);
        return flag;
    }
}
