package com.vf.bowling;

import com.vf.bowling.model.FinalScore;
import com.vf.bowling.model.FrameScore;

public class BowlingScoring {
    private FinalScore finalScore;
    private FrameScore[] frameScores;

    public BowlingScoring(FrameScore[] frameScores) {
        this.frameScores = frameScores;
        this.finalScore = null;
    }

    public BowlingScoring(FrameScore[] frameScores, FinalScore finalScore) {
        this.frameScores = frameScores;
        this.finalScore = finalScore;
    }

    public int accumulateScores() {
        int totalFrameScore = 0;
        int bonusScore = 0;
        for (int index = 0; index < this.frameScores.length; index++) {
            bonusScore += bonusScore(index);
            totalFrameScore += this.frameScores[index].score();
        }
        return totalFrameScore + bonusScore;
    }

    private int bonusScore(int index) {
        if (this.frameScores[index].isStrike()) {
            return strikeBonusScore(index);
        }
        if (this.frameScores[index].isSpare()) {
            return spareBonusScore(index);
        }
        return 0;
    }

    private int strikeBonusScore(int index) {
        if (index == this.frameScores.length - 1) {
            if (finalScore != null &&
                    this.frameScores[index].isStrike()) {
                return this.finalScore.score();
            }
            return 0;
        }
        if (index == this.frameScores.length - 2) {
            if (finalScore != null &&
                    this.frameScores[index + 1].isStrike()) {
                return this.frameScores[index + 1].score() + this.finalScore.firstScore();
            }
            return this.frameScores[index + 1].score();
        }
        return this.frameScores[index + 1].isStrike() ?
                this.frameScores[index + 1].firstScore() + this.frameScores[index + 2].firstScore() :
                this.frameScores[index + 1].score();
    }

    private int spareBonusScore(int index) {
        if (index == this.frameScores.length - 1) {
            if (finalScore != null && this.frameScores[index].isSpare()) {
                return this.finalScore.score();
            }
            return 0;
        }
        return this.frameScores[index + 1].firstScore();
    }
}
