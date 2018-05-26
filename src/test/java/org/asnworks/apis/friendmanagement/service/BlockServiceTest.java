/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.asnworks.apis.friendmanagement.dto.ToggleSubscriptionDTO;
import org.junit.Test;

/**
 * @author sudambat
 *
 */
public class BlockServiceTest {

    @Test
    public void testBlock() {
        BlockServiceImpl mockBlockService = mock(BlockServiceImpl.class);
        final ToggleSubscriptionDTO toggleSubscriptionDTO = new ToggleSubscriptionDTO();
        toggleSubscriptionDTO.setRequestor("abc@gmail.com");
        toggleSubscriptionDTO.setTarget("pqr@gmail.com");
        doNothing().when(mockBlockService).block(toggleSubscriptionDTO);
    }
}
