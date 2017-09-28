package com.boss.brainer.service;

import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.domain.mongo.BaseActiveGame;
import com.boss.brainer.repository.ActiveGameRepository;
import com.boss.brainer.repository.BaseActiveGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultActiveGameService implements ActiveGameService {

    @Autowired
    private ActiveGameRepository activeGameRepository;

    @Autowired
    private BaseActiveGameRepository baseActiveGameRepository;


    @Override
    public ActiveGame findByGameId(String id) {
        return activeGameRepository.findOne(id);
    }

    public ActiveGame saveOrUpdate(ActiveGame game){
        return activeGameRepository.save(game);
    }


    @Override
    public List<BaseActiveGame> findListByUsername(String username) {
        return baseActiveGameRepository.findBaseActiveGamesByUser(username);
    }
}
