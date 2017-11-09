package com.boss.brainer.rest;

import com.boss.brainer.domain.mysql.User;
import com.boss.brainer.service.UserService;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Component
@Path("/login")
public class LoginRestController {

    private UserService userService;

    public LoginRestController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User autentificateUser(@QueryParam(value="login") String login) {
        //return userDetailsService.loadUserByUsername(login);
        return userService.fingByUsername(login);
    }
}
