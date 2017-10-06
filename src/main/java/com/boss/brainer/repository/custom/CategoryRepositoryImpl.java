package com.boss.brainer.repository.custom;

import com.boss.brainer.domain.mongo.Category;
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
public class CategoryRepositoryImpl implements CategoryRepositoryCustom{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Category findRandomCategory() {
        DBCollection collection = mongoTemplate.getCollection("category");

        DBObject group = new BasicDBObject("$sample", new BasicDBObject("size", 1));

        AggregationOutput output = collection.aggregate(Arrays.asList(group));

        return MongoConverter.convertToObject(Category.class, output, mongoTemplate);
    }
}
