package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

@Data
@Document(collection = "category")
public class Category {

    private String _id;
    private String title;

    public Category(String title){
        this.title = title;
    }

    public Category(){

    }
}
