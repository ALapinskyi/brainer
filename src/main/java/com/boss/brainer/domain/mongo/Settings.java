package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "settings")
public class Settings {

    private String _id;
    private String userId;
    private boolean soundsOn;
}
