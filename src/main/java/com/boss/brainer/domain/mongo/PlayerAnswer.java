package com.boss.brainer.domain.mongo;

import lombok.Data;

@Data
public class PlayerAnswer {

    private String user;
    private Answer answer;
    private boolean correct;

}
