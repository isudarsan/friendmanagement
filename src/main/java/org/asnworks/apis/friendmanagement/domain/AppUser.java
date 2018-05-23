/**
 * 
 */
package org.asnworks.apis.friendmanagement.domain;

/**
 * @author sudambat
 */
public class AppUser implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1880484074881242825L;

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;

    public AppUser() {
    }

    public AppUser(Long id, String firstName, String lastName, String gender, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
