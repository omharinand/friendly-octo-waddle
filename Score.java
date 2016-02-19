package com.vf.bowling.model;

public class Score {

    public static final int MAX_SCORE_PER_FRAME = 10;
    protected static final int NON_EXISTING_ATTEMPT = -1;

    protected int firstScore;
    protected int secondScore;

    public Score(int firstScore, int secondScore) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public Score(int firstScore) {
        this.firstScore = firstScore;
        this.secondScore = NON_EXISTING_ATTEMPT;
    }

    public int firstScore() {
        return this.firstScore;
    }

    public int score() {
        if (this.secondScore == NON_EXISTING_ATTEMPT) {
            return this.firstScore;
        }
        return this.firstScore + this.secondScore;
    }
}