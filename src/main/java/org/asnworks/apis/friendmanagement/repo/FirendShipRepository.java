/**
 * 
 */
package org.asnworks.apis.friendmanagement.repo;

import java.util.List;

import org.asnworks.apis.friendmanagement.domain.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author sudambat
 */
public interface FirendShipRepository extends JpaRepository<Friend, String> {

    @Query(nativeQuery = true)
    List<String> fetchFriends(@Param("person") final String person);
}
