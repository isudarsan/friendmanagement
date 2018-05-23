package org.asnworks.apis.friendmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author sudambat
 */
@SpringBootApplication
@Import({

    JPAConfig.class,
    ServiceConfig.class,

})

public class FriendmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendmanagementApplication.class, args);
    }

}
