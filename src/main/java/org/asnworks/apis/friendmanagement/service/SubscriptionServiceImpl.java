/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import java.util.List;

import org.asnworks.apis.friendmanagement.domain.Subscription;
import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;
import org.asnworks.apis.friendmanagement.exceptions.DuplicateSubscriptionRequest;
import org.asnworks.apis.friendmanagement.exceptions.InvalidRequestException;
import org.asnworks.apis.friendmanagement.repo.SubscribeRepository;
import org.asnworks.apis.friendmanagement.utils.ValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sudambat
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private static final Logger LOG = LoggerFactory.getLogger(SubscriptionServiceImpl.class);
    @Autowired
    SubscribeRepository subscribeRepository;

    @Autowired
    ValidationUtils validationUtils;

    @Override
    public void scubscribe(final ToggleSubscriptionDTO toggleSubscriptionDTO) {
        LOG.info("Start :: scubscribe {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
        checkSubscriptionCriteria(toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
        LOG.info("End :: scubscribe {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());

    }

    /**
     * @param requestor
     * @param target This method checks the subscription criteria
     */
    private void checkSubscriptionCriteria(final String requestor, final String target) {
        LOG.info("Start :: checkSubscriptionCriteria {} {}", requestor, target);
        if (requestor == null || target == null) {
            LOG.info("InvalidRequestException :: checkSubscriptionCriteria {} {}", requestor, target);
            throw new InvalidRequestException("Invalid request : should have requestor and target");
        }

        validationUtils.validateFriendShipCriteria(requestor, target);

        List<String> targetSubscribers = subscribeRepository.fetchSubscribers(target);

        if (targetSubscribers.contains(requestor)) {
            LOG.info("DuplicateSubscriptionRequest :: checkSubscriptionCriteria {} {}", requestor, target);
            throw new DuplicateSubscriptionRequest(requestor, target);
        }

        subscribeRepository.save(createSubscription(requestor, target));
        LOG.info("End :: checkSubscriptionCriteria {} {}", requestor, target);

    }

    /**
     * @param requestor
     * @param target
     * @return Subscription
     */
    private Subscription createSubscription(final String requestor, final String target) {
        return new Subscription(requestor, target);
    }

}
