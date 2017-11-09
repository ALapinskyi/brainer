package com.boss.brainer.logic.creator;

import com.boss.brainer.annotation.Game;
import com.boss.brainer.domain.mongo.GameMode;
import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mongo.*;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Game(GameMode.SIMPLE)
@Component
public class SimpleGameCreator extends BaseGameCreator {


    private GameType[] SUPPORTED_TYPES = {GameType.R5_Q5};

    @Override
    public ActiveGame createNewGameInstance(NewGameModel game) {

        ActiveGame activeGame = new ActiveGame();

        GameUser gameUser = new GameUser();
        gameUser.setNumber(1);
        gameUser.setUsername(game.getUser().getUsername());

        List<GameUser> userList = new ArrayList();
        userList.add(gameUser);

        activeGame.setPlayers(userList);
        activeGame.setPendingUser(game.getUser().getUsername());

        Calendar currentTime = Calendar.getInstance();
        activeGame.setCreationTime(currentTime.getTime());

        currentTime.add(Calendar.MILLISECOND, DEFAULT_PENDING);
        activeGame.setPendingTime(currentTime.getTime());

        activeGame.setRounds(createRounds(game.getType()));

        return activeGame;
    }

    private List<Round> createRounds(GameType type){
        List<Round> roundList = new ArrayList<>();

        for(int i = 0; i < type.getRounds(); i++){
            Round round = new Round();

            round.setNumber(i + 1);
            round.setQuestions(createQuestions(type));

            roundList.add(round);
        }

        return roundList;
    }

    private List<GameQuestion> createQuestions(GameType type){
        List<GameQuestion> questionList = new ArrayList<>();

        for(int i = 0; i < type.getRounds(); i++){
            questionList.add(new GameQuestion());
        }

        return questionList;
    }

    @Override
    public boolean supports(GameType type) {
        return ArrayUtils.contains(SUPPORTED_TYPES, type);
    }
}
