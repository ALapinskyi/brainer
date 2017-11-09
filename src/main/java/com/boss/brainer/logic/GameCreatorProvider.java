package com.boss.brainer.logic;

import com.boss.brainer.annotation.Game;
import com.boss.brainer.domain.mongo.GameMode;
import com.boss.brainer.domain.mongo.GameType;
import com.boss.brainer.logic.creator.BaseGameCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameCreatorProvider {

    private final Map<GameMode, BaseGameCreator> creatorsByMode = new HashMap<>();

    @Autowired
    public GameCreatorProvider(List<BaseGameCreator> gameCreatorList){
        gameCreatorList.forEach(
                creator -> creatorsByMode.put(creator.getClass().getAnnotation(Game.class).value(), creator));
    }

    public BaseGameCreator getGameCreator(GameMode mode, GameType type){
        BaseGameCreator creator = creatorsByMode.get(mode);

        if(creator.supports(type)){
            return creator;
        }
        return null;
    }
}
