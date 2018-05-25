/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;

/**
 * @author sudambat
 *
 */
public interface BlockService {

    void block(final ToggleSubscriptionDTO toggleSubscriptionDTO);
}
