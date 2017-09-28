package com.boss.brainer.rest;

import com.boss.brainer.domain.mongo.Question;
import com.boss.brainer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Component
@Path("/question")
public class QuestionRestController {

    @Autowired
    private QuestionService questionService;

    @GET
    @Produces("application/json")
    public List<Question> findNeededCount(@QueryParam(value="count") Integer count) {
        return questionService.findRandomQuestions(count);
    }
}
