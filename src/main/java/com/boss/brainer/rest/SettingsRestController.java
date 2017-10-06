package com.boss.brainer.rest;

import com.boss.brainer.domain.mongo.Settings;
import com.boss.brainer.domain.mysql.User;
import com.boss.brainer.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/settings")
public class SettingsRestController {

    @Autowired
    private SettingsService settingsService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Settings getSettings() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return settingsService.findByUserId(user.getId().toString());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Settings saveSettings(Settings settings) {

        return settingsService.saveSettings(settings);
    }
}
