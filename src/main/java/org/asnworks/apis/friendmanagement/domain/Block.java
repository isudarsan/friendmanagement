/**
 * 
 */
package org.asnworks.apis.friendmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author sudambat
 */
@Entity
@NamedQuery(name = "Block.fetchBlockers",
    query = "SELECT b.blocker FROM Block b WHERE b.blockee=:blockee")
public class Block implements java.io.Serializable {

    private static final long serialVersionUID = -5064330509061005796L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String blocker;
    private String blockee;

    public Block() {
    }

    public Block(String blocker, String blockee) {
        super();
        this.blocker = blocker;
        this.blockee = blockee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlocker() {
        return blocker;
    }

    public void setBlocker(String blocker) {
        this.blocker = blocker;
    }

    public String getBlockee() {
        return blockee;
    }

    public void setBlockee(String blockee) {
        this.blockee = blockee;
    }

}
