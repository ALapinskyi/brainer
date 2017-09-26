package com.boss.brainer.service;

import com.boss.brainer.domain.mongo.Question;
import com.boss.brainer.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DefaultQuestionService implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findRandomQuestions(Integer count) {

        List<Question> resultList = new LinkedList<>();

        while(resultList.size() < count){

            Question result = questionRepository.findRandomQuestion();

            if(resultList.stream().noneMatch(question -> question.get_id().equals(result.get_id())))
                resultList.add(result);
        }

        return resultList;
    }
}
