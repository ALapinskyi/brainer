package com.boss.brainer.domain.mongo;

import lombok.Data;

@Data
public class Answer {

    private Long id;
    private String description;

    public Answer(String description){
        this.description = description;
    }
}
