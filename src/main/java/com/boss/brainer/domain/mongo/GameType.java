package com.boss.brainer.domain.mongo;

public enum GameType {

    R5_Q5(5, 5, true);

    private int rounds;
    private int questions;
    private boolean extraRound;

    GameType(int rounds,int questions, boolean extraRound){
        this.rounds = rounds;
        this.questions = questions;
        this.extraRound = extraRound;
    }

    public int getRounds() {
        return rounds;
    }

    public int getQuestions() {
        return questions;
    }

    public boolean isExtraRound() {
        return extraRound;
    }
}
