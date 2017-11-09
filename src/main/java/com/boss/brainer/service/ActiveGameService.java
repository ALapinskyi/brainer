package com.boss.brainer.service;

import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mongo.GameMode;
import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.domain.mongo.BaseActiveGame;
import com.boss.brainer.domain.mongo.GameType;

import java.util.List;

public interface ActiveGameService {

    ActiveGame saveOrUpdate(ActiveGame game);

    ActiveGame findByGameId(String id);

    ActiveGame findPendingGame(NewGameModel model);

    List<BaseActiveGame> findListByUsername(String username);

}
