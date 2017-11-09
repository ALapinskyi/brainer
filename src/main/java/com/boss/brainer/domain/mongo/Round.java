package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class Round {

    private String _id;
    private Integer number;
    private Category category;
    private List<GameQuestion> questions;

    public Round(){
        _id = new ObjectId().toString();
    }
}
