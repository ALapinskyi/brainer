package com.boss.brainer.repository;

import com.boss.brainer.domain.mongo.BaseActiveGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BaseActiveGameRepository extends MongoRepository<BaseActiveGame, String> {

    @Query(value="{'$or':[ {'firstUser' : ?0}, {'secondUser' : ?0} ] }")
    List<BaseActiveGame> findBaseActiveGamesByUser(String user);
}
