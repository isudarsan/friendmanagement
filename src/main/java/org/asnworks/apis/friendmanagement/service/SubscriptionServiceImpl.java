/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import java.util.List;

import org.asnworks.apis.friendmanagement.domain.Subscription;
import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;
import org.asnworks.apis.friendmanagement.repo.SubscribeRepository;
import org.asnworks.apis.friendmanagement.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sudambat
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscribeRepository subscribeRepository;

    @Autowired
    ValidationUtils validationUtils;

    @Override
    public void scubscribe(final ToggleSubscriptionDTO toggleSubscriptionDTO) {
        checkSubscriptionCriteria(toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());

    }

    private void checkSubscriptionCriteria(final String requestor, final String target) {
        if (requestor == null || target == null) {
            // throw WrongRequestFormatException("Must have fields 'requestor' and 'target'");
        }

        validationUtils.validateFriendShipCriteria(requestor, target);

        List<String> targetSubscribers = subscribeRepository.fetchSubscribers(target);

        if (targetSubscribers.contains(requestor)) {
            System.out.println("Already subscribed exception");
        }

        subscribeRepository.save(createSubscription(requestor, target));

    }

    private Subscription createSubscription(final String requestor, final String target) {
        return new Subscription(requestor, target);
    }

}
