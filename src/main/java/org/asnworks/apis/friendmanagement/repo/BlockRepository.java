/**
 * 
 */
package org.asnworks.apis.friendmanagement.repo;

import java.util.List;

import org.asnworks.apis.friendmanagement.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author sudambat
 *
 */
public interface BlockRepository extends JpaRepository<Block, Long> {

    /**
     * @param blockee
     * @return Blockers for a given blockee
     */
    List<String> fetchBlockers(@Param("blockee") final String blockee);
}
