package com.boss.brainer.util;

import com.mongodb.AggregationOutput;
import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.LinkedList;
import java.util.List;

public class MongoConverter {

    public static <T extends Object> List<T> convertToList(Class<T> resultClass, AggregationOutput output, MongoTemplate mongoTemplate){
        List<T> resultList = new LinkedList<>();

        output.results().forEach(object -> {
            resultList.add(mongoTemplate.getConverter().read(resultClass, object));
        });
        return resultList;
    }
    public static <T extends Object> T convertToObject(Class<T> resultClass, AggregationOutput output, MongoTemplate mongoTemplate){
        return mongoTemplate.getConverter().read(resultClass, output.results().iterator().next());
    }


    public static <T extends Object> List<T> convertToList(Class<T> resultClass, List<DBObject> object, MongoTemplate mongoTemplate){
        List<T> resultList = new LinkedList<>();

        object.forEach(obj -> {
            resultList.add(mongoTemplate.getConverter().read(resultClass, obj));
        });
        return resultList;
    }
}
