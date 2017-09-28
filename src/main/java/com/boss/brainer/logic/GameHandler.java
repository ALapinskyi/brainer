package com.boss.brainer.logic;

import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.logic.creator.BaseGameCreator;
import com.boss.brainer.service.ActiveGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameHandler {

    @Autowired
    private ActiveGameService activeGameService;

    @Autowired
    private GameCreatorProvider gameCreatorProvider;

    public ActiveGame createNewGame(NewGameModel model){
        BaseGameCreator creatorProvider = gameCreatorProvider.getGameCreator(model.getMode(), model.getType());

        ActiveGame game = creatorProvider.createNewGameInstance(model);

        activeGameService.saveOrUpdate(game);

        return  game;
    }
}
