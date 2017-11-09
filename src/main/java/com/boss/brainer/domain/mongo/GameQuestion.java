package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Map;

@Data
public class GameQuestion {

    private String _id;
    private Question question;
    private Map<Integer, Answer> playerAnswers;


    public GameQuestion(){
        _id = new ObjectId().toString();
    }
}
