package com.boss.brainer.repository;

import com.boss.brainer.domain.mongo.ActiveGame;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActiveGameRepository extends MongoRepository<ActiveGame, String> {

    //ActiveGame findActiveGameByFirstUserAndId(String firstUser, ObjectId id);
}
