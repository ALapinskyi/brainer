package com.boss.brainer.logic.creator;

import com.boss.brainer.annotation.Game;
import com.boss.brainer.domain.mongo.GameMode;
import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.domain.mongo.GameType;
import com.boss.brainer.domain.mysql.User;
import org.springframework.stereotype.Component;

@Game(GameMode.BLITZ)
@Component
public class BlitzGameCreator extends BaseGameCreator {

    @Override
    public ActiveGame createNewGameInstance(NewGameModel game) {
        return null;
    }

    @Override
    public ActiveGame addSecondUser(ActiveGame game, User user) {
        return null;
    }


    @Override
    public boolean supports(GameType type) {
        return false;
    }
}
