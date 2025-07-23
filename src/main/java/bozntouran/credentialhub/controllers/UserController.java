package bozntouran.credentialhub.controllers;

import bozntouran.credentialhub.entities.UserData;
import bozntouran.credentialhub.services.UserServiceImpl;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@Log4j2
public class UserController {

    private final UserServiceImpl userDetailsServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    private static final String USER_URL = "/api/users";
    private static final String NEW_USER_URL = USER_URL + "/newUser";

    @PostMapping(NEW_USER_URL)
    public UserData user(@RequestBody UserData user) {
        UserData userData = userDetailsServiceImpl.registerNewUser(user);
        if (userData != null) {
            log.info("New user received: {}", user);
        }

        return userData;
    }

    @GetMapping(USER_URL+"/all")
    public List<UserData> getUsers() {
        return userDetailsServiceImpl.getAllUsers();
    }
}
