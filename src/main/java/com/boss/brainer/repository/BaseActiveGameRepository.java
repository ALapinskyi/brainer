package com.boss.brainer.repository;

import com.boss.brainer.domain.mongo.BaseActiveGame;
import com.boss.brainer.repository.custom.BaseActiveGameRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseActiveGameRepository extends MongoRepository<BaseActiveGame, String>, BaseActiveGameRepositoryCustom {

    //@Query(value="{'$or':[ {'firstUser' : ?0}, {'secondUser' : ?0} ] }")
    //List<BaseActiveGame> findBaseActiveGamesByUser(String user);
}
