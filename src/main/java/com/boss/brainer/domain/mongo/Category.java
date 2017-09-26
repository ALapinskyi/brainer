package com.boss.brainer.domain.mongo;

//TODO auto insert

import lombok.Data;

import javax.persistence.Id;
import java.util.UUID;

@Data
public class Category {

    @Id
    private UUID id;
    private String title;

    public Category(String title){
        this.title = title;
    }
}
