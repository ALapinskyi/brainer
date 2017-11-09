package com.boss.brainer.repository.custom;

import com.boss.brainer.domain.mongo.BaseActiveGame;
import com.boss.brainer.util.MongoConverter;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseActiveGameRepositoryImpl implements BaseActiveGameRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<BaseActiveGame> findBaseActiveGamesByUser(String user) {
        DBCollection collection = mongoTemplate.getCollection("active_game");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("players.username", user);

        DBCursor cursor = collection.find(whereQuery);

        return MongoConverter.convertToList(BaseActiveGame.class, cursor.toArray(), mongoTemplate);
    }
}
