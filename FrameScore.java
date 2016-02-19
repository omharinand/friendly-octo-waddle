package com.vf.bowling.model;

public class FrameScore extends Score {

    public FrameScore(int firstScore, int secondScore) {
        super(firstScore, secondScore);
    }

    public FrameScore(int firstScore) {
        super(firstScore);
    }

    public boolean isStrike() {
        return this.secondScore == NON_EXISTING_ATTEMPT;
    }

    public boolean isSpare() {
        return !isStrike() &&
                this.firstScore + this.secondScore == MAX_SCORE_PER_FRAME;
    }
}