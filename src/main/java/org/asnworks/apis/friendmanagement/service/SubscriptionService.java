/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;

/**
 * @author sudambat
 *
 */
public interface SubscriptionService {

    /**
     * @param toggleSubscriptionDTO
     */
    void scubscribe(final ToggleSubscriptionDTO toggleSubscriptionDTO);

}
