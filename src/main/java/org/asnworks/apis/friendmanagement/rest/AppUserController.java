/**
 * 
 */
package org.asnworks.apis.friendmanagement.rest;

import org.asnworks.apis.friendmanagement.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudambat
 *
 */
@RestController
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/hello")
    public String signUp1() {
        return "Hello, world";
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody String email) {
        return "Hello, world";
    }
}
