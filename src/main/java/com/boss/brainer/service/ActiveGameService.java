package com.boss.brainer.service;

import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.domain.mongo.BaseActiveGame;

import java.util.List;

public interface ActiveGameService {

    ActiveGame saveOrUpdate(ActiveGame game);

    ActiveGame findByGameId(String id);

    List<BaseActiveGame> findListByUsername(String username);

}
