package com.boss.brainer.logic.creator;

import com.boss.brainer.annotation.Game;
import com.boss.brainer.domain.GameMode;
import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mongo.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Game(GameMode.SIMPLE)
@Component
public class SimpleGameCreator extends BaseGameCreator {


    private GameType[] SUPPORTED_TYPES = {GameType.R5_Q5};

    @Override
    public ActiveGame createNewGameInstance(NewGameModel game) {

        ActiveGame activeGame = new ActiveGame();

        activeGame.setFirstUser(game.getUser().getUsername());
        activeGame.setFirstUserScore(0);
        activeGame.setSecondUserScore(0);
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

            round.setRoundNumber(i + 1);
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
