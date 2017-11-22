package com.boss.brainer.logic.creator;

import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.domain.mongo.GameType;
import com.boss.brainer.domain.mysql.User;
import org.springframework.beans.factory.annotation.Value;

public abstract class BaseGameCreator {

    @Value("${brainer.answer.perdingTime}")
    protected Integer DEFAULT_PENDING;

    public abstract ActiveGame createNewGameInstance(NewGameModel game);

    public abstract ActiveGame addSecondUser(ActiveGame game, User user);

    public abstract boolean supports(GameType type);
}
