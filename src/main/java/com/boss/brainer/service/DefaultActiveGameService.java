package com.boss.brainer.service;

import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.domain.mongo.BaseActiveGame;
import com.boss.brainer.repository.ActiveGameRepository;
import com.boss.brainer.repository.BaseActiveGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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

    @Override
    public ActiveGame findPendingGame(NewGameModel model) {
        List<ActiveGame> pendingGames = activeGameRepository.findByModeAndTypeAndPendingUserIsNull(model.getMode().toString(), model.getType().toString());
        if(CollectionUtils.isEmpty(pendingGames)) {
            return null;
        } else {
            return pendingGames
                    .stream()
                    .filter(
                            game -> game.getPlayers()
                                    .stream()
                                    .filter(player -> !model.getUser().equals(player.getUsername())).findFirst().isPresent())
                    .findFirst().get();
        }
    }

    public ActiveGame saveOrUpdate(ActiveGame game){
        return activeGameRepository.save(game);
    }


    @Override
    public List<BaseActiveGame> findListByUsername(String username) {
        return baseActiveGameRepository.findBaseActiveGamesByUser(username);
    }
}
