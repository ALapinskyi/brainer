package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

@Data
public class GameQuestion {

    private String _id;
    private Integer number;
    private Question question;
    private List<PlayerAnswer> playerAnswers;


    public GameQuestion(){
        _id = new ObjectId().toString();
    }

}
