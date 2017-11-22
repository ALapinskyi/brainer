package com.boss.brainer.service;

import com.boss.brainer.domain.mongo.Category;
import com.boss.brainer.domain.mongo.Question;

import java.util.List;

public interface QuestionService {

    List<Question> findRandomQuestions(Integer count, String categoryId);
}
