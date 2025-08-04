package bozntouran.credentialhub.controllers;


import bozntouran.credentialhub.entities.Company;
import bozntouran.credentialhub.entities.UserData;
import bozntouran.credentialhub.services.CompanyService;
import bozntouran.credentialhub.services.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerWebLayerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserServiceImpl userService;

    private UserData userData;

    void setup(){
        userData = new UserData();
        userData.setPassword("password");
        userData.setUsername("username");
        userData.setEmail("email@gmail.com");

    }

    @Test
    void createUser() throws Exception {

        when(userService.registerNewUser(any(UserData.class))).thenReturn(userData);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/users/newUser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userData));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String responseBody = result.getResponse().getContentAsString();

        UserData reponseUserData = new ObjectMapper().readValue(responseBody, UserData.class);

        Assertions.assertEquals(userData.getPassword(), reponseUserData.getPassword());
        Assertions.assertEquals(userData.getUsername(), reponseUserData.getUsername());
        Assertions.assertEquals(userData.getEmail(), reponseUserData.getEmail());


    }
}
