package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class GameQuestion {

    private String _id;
    private Question questionId;
    private Answer firstPlayerAnswer;
    private Answer secondPlayerAnswer;


    public GameQuestion(){
        _id = new ObjectId().toString();
    }
}
