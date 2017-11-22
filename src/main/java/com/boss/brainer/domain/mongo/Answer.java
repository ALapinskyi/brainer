package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Answer {

    private String _id;
    private String description;

    public Answer(String description){
        this._id = new ObjectId().toString();
        this.description = description;
    }

    public Answer(){

    }
}
