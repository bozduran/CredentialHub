package bozntouran.reviewmycert.controllers;

import bozntouran.reviewmycert.entities.UserData;
import bozntouran.reviewmycert.services.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity user(@RequestBody UserData user) {
        UserData userData = userDetailsServiceImpl.registerNewUser(user);
        if (userData != null) {
            log.info("New user received: {}", user);
        }

        // change to rsponse entity with a  status created and not  the entity create
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(USER_URL+"/all")
    public List<UserData> getUsers() {
        return userDetailsServiceImpl.getAllUsers();
    }
}
