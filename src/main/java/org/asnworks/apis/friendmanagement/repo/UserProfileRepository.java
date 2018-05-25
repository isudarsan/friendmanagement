/**
 * 
 */
package org.asnworks.apis.friendmanagement.repo;

import org.asnworks.apis.friendmanagement.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sudambat
 *
 */

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

}
