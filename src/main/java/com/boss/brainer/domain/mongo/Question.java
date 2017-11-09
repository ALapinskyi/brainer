package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "question")
public class Question {

    private String _id;
    private String questionDescription;
    private byte[] image;
    private Category category;
    private QuestionType type;
    private Map<String, Answer> answers;
}
