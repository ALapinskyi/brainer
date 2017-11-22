package com.boss.brainer.rest;

import com.boss.brainer.domain.mongo.Category;
import com.boss.brainer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/category")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories(@QueryParam(value = "count") Integer count, @QueryParam(value = "all") boolean all) {
        if(all)
            return categoryService.findAll();
        else
            return categoryService.findRandomCategories(count);
    }
}
