package com.example.demo.endpoint;

import com.example.demo.model.Watch;
import com.example.demo.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by renliang on 2019/9/8.
 */
@Service
@Path("watches")
public class WatchEndPoint {

    private final WatchService watchService;

    @Autowired
    public WatchEndPoint(WatchService watchService) {
        this.watchService = watchService;
    }

    @GET
    @Path("{watch_no}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findWatchByNo(@PathParam("watch_no") String watchNo) {
        Watch watch = watchService.findWatchByNo(watchNo);
        return Response
                .status(Response.Status.OK)
                .entity(watch)
                .build();
    }

}
