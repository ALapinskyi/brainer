package com.boss.brainer.repository.custom;

import com.boss.brainer.domain.mongo.BaseActiveGame;

import java.util.List;

public interface BaseActiveGameRepositoryCustom {

    List<BaseActiveGame> findBaseActiveGamesByUser(String user);
}
