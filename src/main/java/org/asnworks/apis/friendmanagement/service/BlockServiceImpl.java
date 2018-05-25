/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import java.util.List;

import org.asnworks.apis.friendmanagement.domain.Block;
import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;
import org.asnworks.apis.friendmanagement.repo.BlockRepository;
import org.asnworks.apis.friendmanagement.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sudambat
 */
@Service
public class BlockServiceImpl implements BlockService {

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
        checkBlockCriteria(toggleSubscriptionDTO.getRequestor(), toggleSubscriptionDTO.getTarget());

    }

    /**
     * @param requestor
     * @param target
     */
    private void checkBlockCriteria(final String requestor, final String target) {
        if (requestor == null || target == null) {
            // throw WrongRequestFormatException("Must have fields 'requestor' and 'target'");
        }

        validationUtils.validateFriendShipCriteria(requestor, target);

        List<String> targetBlockers = blockRepository.fetchBlockers(target);

        if (targetBlockers.contains(requestor)) {
            // throw new AlreadyBlockedException(requestor, target);
        }

        blockRepository.save(createBlock(requestor, target));

    }

    /**
     * @param requestor
     * @param target
     * @return
     */
    private Block createBlock(final String requestor, final String target) {
        return new Block(requestor, target);
    }

}
