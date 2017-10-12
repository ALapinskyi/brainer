package com.boss.brainer.configuration;

import com.boss.brainer.rest.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ActiveGameRestController.class);
        register(CategoryRestController.class);
        register(LoginRestController.class);
        register(QuestionRestController.class);
        register(SettingsRestController.class);
    }
}

