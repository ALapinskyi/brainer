package com.boss.brainer.repository.custom;

import com.boss.brainer.domain.mongo.Question;
import com.boss.brainer.util.MongoConverter;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class QuestionRepositoryImpl implements QuestionRepositoryCustom{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Question findRandomQuestion(String categoryId) {
        DBCollection collection = mongoTemplate.getCollection("question");

        DBObject group = new BasicDBObject("$sample", new BasicDBObject("size", 1));
        //group.put("category._id", categoryId);

        AggregationOutput output = collection.aggregate(Arrays.asList(group));

        return MongoConverter.convertToObject(Question.class, output, mongoTemplate);
    }
}
