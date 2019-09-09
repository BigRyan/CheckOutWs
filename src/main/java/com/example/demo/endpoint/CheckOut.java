package com.example.demo.endpoint;

import com.example.demo.service.WatchService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by renliang on 2019/9/8.
 */
@Service
@Path("checkout")
public class CheckOut {
    private WatchService watchService = null;

    @Autowired
    public CheckOut(WatchService watchService) {
        this.watchService = watchService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String doCheckout(String jsonBody) {
        Gson gs = new Gson();
        List<String> watches = gs.fromJson(jsonBody, new TypeToken<ArrayList<String>>(){}.getType());
        int price = watchService.getTotalPrice(watches);
        String template = "{\"price\":\"%s\"}";
        return String.format(template, price);
    }
}
