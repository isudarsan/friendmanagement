/**
 * 
 */
package org.asnworks.apis.friendmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author sudambat Entity for UserProfile
 */
@Entity
public class UserProfile implements java.io.Serializable {

    private static final long serialVersionUID = 1880484074881242825L;

    @Id
    private String email;

    public UserProfile() {
    }

    public UserProfile(String email) {
        super();
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
