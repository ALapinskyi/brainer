package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "question")
public class Question {

    private String _id;
    private String questionDescription;
    private byte[] image;
    private QuestionType type;
    private Answer correctAnswer;
    private Answer answer1;
    private Answer answer2;
    private Answer answer3;
}
