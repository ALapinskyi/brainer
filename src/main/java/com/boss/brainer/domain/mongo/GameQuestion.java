package com.boss.brainer.domain.mongo;

import lombok.Data;

@Data
public class GameQuestion {

    private Integer id;
    private Question questionId;
    private Answer firstPlayerAnswer;
    private Answer secondPlayerAnswer;
}
