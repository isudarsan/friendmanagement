/**
 * 
 */
package org.asnworks.apis.friendmanagement.repo;

import java.util.List;

import org.asnworks.apis.friendmanagement.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author sudambat
 *
 */
public interface SubscribeRepository extends JpaRepository<Subscription, Long> {

    List<String> fetchSubscribers(@Param("subscribee") final String subscribee);

}
