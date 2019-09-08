package com.example.demo.endpoint;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by renliang on 2019/9/8.
 */
@Service
@Path("/checkout")
public class CheckOut {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String doCheckout() {
        return "{\"price\":\"12345\"}";
    }
}
