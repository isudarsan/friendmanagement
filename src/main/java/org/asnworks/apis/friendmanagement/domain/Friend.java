/**
 * 
 */
package org.asnworks.apis.friendmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

/**
 * @author sudambat
 */
@Entity
@NamedNativeQuery(name = "Friend.fetchFriends",
    query = "SELECT personTwo AS friend FROM Friend WHERE personOne =:person" + " UNION "
        + "SELECT personOne AS friend FROM Friend WHERE personTwo =:person")
public class Friend implements java.io.Serializable {

    private static final long serialVersionUID = -6315870426453041934L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String personOne;
    private String personTwo;

    public Friend() {
    }

    public Friend(String personOne, String personTwo) {
        super();
        this.personOne = personOne;
        this.personTwo = personTwo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonOne() {
        return personOne;
    }

    public void setPersonOne(String personOne) {
        this.personOne = personOne;
    }

    public String getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(String personTwo) {
        this.personTwo = personTwo;
    }

}
