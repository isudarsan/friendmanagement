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
 * @author sudambat Entity for Subscription
 */
@Entity
@NamedQuery(name = "Subscription.fetchSubscribers",
    query = "SELECT s.subscriber FROM Subscription s WHERE s.subscribee=:subscribee")
public class Subscription implements java.io.Serializable {

    private static final long serialVersionUID = -3791874896475946219L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subscriber;
    private String subscribee;

    public Subscription() {
    }

    public Subscription(String subscriber, String subscribee) {
        super();
        this.subscriber = subscriber;
        this.subscribee = subscribee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getSubscribee() {
        return subscribee;
    }

    public void setSubscribee(String subscribee) {
        this.subscribee = subscribee;
    }

}
