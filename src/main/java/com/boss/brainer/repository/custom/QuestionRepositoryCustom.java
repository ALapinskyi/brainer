package com.boss.brainer.repository.custom;

import com.boss.brainer.domain.mongo.Question;

public interface QuestionRepositoryCustom {

    Question findRandomQuestion();
}
