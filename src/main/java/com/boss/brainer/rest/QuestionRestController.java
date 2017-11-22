package com.boss.brainer.rest;

import com.boss.brainer.domain.mongo.Question;
import com.boss.brainer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/question")
public class QuestionRestController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private QuestionService questionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> findNeededCount(@QueryParam(value="count") Integer count, @QueryParam(value="category") String categoryId) {

        //this.template.convertAndSend("/topic/user2", questionService.findRandomQuestions(count).get(0));

        return questionService.findRandomQuestions(count, categoryId);
    }

}
