/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import java.util.List;

import org.asnworks.apis.friendmanagement.domain.Block;
import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;
import org.asnworks.apis.friendmanagement.exceptions.FriendBlockedException;
import org.asnworks.apis.friendmanagement.exceptions.InvalidRequestException;
import org.asnworks.apis.friendmanagement.repo.BlockRepository;
import org.asnworks.apis.friendmanagement.utils.ValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sudambat
 */
@Service
public class BlockServiceImpl implements BlockService {

    private static final Logger LOG = LoggerFactory.getLogger(BlockServiceImpl.class);
    @Autowired
    ValidationUtils validationUtils;

    @Autowired
    BlockRepository blockRepository;

    /*
     * (non-Javadoc)
     * @see org.asnworks.apis.friendmanagement.service.BlockService#block(org.asnworks.apis.friendmanagement.domain.ToggleSubscription)
     */
    @Override
    public void block(ToggleSubscriptionDTO toggleSubscriptionDTO) {
        LOG.info("Start :: block {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
        checkBlockCriteria(toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());
        LOG.info("End :: block {} {}", toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());

    }

    /**
     * @param requestor
     * @param target This method checks the block criteria
     */
    private void checkBlockCriteria(final String requestor, final String target) {
        LOG.info("Start :: checkBlockCriteria {} {}", requestor, target);
        if (requestor == null || target == null) {
            throw new InvalidRequestException("Invalid request : should have requestor and target");
        }

        validationUtils.validateFriendShipCriteria(requestor, target);

        List<String> targetBlockers = blockRepository.fetchBlockers(target);

        if (targetBlockers.contains(requestor)) {
            LOG.info("FriendBlockedException :: checkBlockCriteria {} {}", requestor, target);
            throw new FriendBlockedException(requestor, target);
        }

        blockRepository.save(createBlock(requestor, target));
        LOG.info("End :: checkBlockCriteria {} {}", requestor, target);

    }

    /**
     * @param requestor
     * @param target
     * @return Block
     */
    private Block createBlock(final String requestor, final String target) {
        return new Block(requestor, target);
    }

}
