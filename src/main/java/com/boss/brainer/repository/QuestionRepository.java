package com.boss.brainer.repository;

import com.boss.brainer.domain.mongo.Question;
import com.boss.brainer.repository.custom.QuestionRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String>, QuestionRepositoryCustom {
}
