package com.boss.brainer.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Component
@Path("/category")
public class FriendsRestController {


    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories(@QueryParam(value = "count") Integer count, @QueryParam(value = "all") Boolean all) {
        if(all)
            return categoryService.findAll();
        else
            return categoryService.findRandomCategories(count);
    }*/
}
