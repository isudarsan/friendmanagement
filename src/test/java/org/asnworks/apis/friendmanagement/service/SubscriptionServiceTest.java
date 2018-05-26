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
public class SubscriptionServiceTest {

    @Test
    public void testSubscribe() {
        SubscriptionServiceImpl mockSubscriptionService = mock(SubscriptionServiceImpl.class);
        final ToggleSubscriptionDTO toggleSubscriptionDTO = new ToggleSubscriptionDTO();
        toggleSubscriptionDTO.setRequestor("abc@gmail.com");
        toggleSubscriptionDTO.setTarget("pqr@gmail.com");
        doNothing().when(mockSubscriptionService).scubscribe(toggleSubscriptionDTO);
    }
}
