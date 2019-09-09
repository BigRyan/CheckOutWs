package com.example.demo.config;

import com.example.demo.endpoint.CheckOut;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by renliang on 2019/9/8.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        packages("com.example.demo.endpoint");
        //register(CheckOut.class);
    }
}
