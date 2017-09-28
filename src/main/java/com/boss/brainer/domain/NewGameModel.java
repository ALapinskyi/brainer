package com.boss.brainer.domain;

import com.boss.brainer.domain.mongo.Category;
import com.boss.brainer.domain.mongo.GameType;
import com.boss.brainer.domain.mysql.User;
import lombok.Data;

@Data
public class NewGameModel {

    private User user;
    private GameMode mode;
    private GameType type;
}
