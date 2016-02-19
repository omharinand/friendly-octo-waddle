
package test.com.vf.bowling;

import com.vf.bowling.BowlingScoring;
import com.vf.bowling.model.FinalScore;
import com.vf.bowling.model.FrameScore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBowling {

    @Test
    public void shouldCalculateBowlingScoreGivenArrayOfScoreWithoutStrikeAndSpare() {

        FrameScore[] frameScores = {
                new FrameScore(1, 2),
                new FrameScore(2, 4)
        };

        int score = new BowlingScoring(frameScores).accumulateScores();

        assertEquals(9, score);
    }

    @Test
    public void shouldCalculateBowlingScoreGivenArrayOfScoreWithStrikes() {

        FrameScore[] frameScores = {
                new FrameScore(1, 2),
                new FrameScore(10),
                new FrameScore(3, 4)
        };

        int score = new BowlingScoring(frameScores).accumulateScores();

        assertEquals(27, score);
    }

    @Test
    public void shouldCalculateBowlingScoreGivenArrayOfScoreWithContinuousStrikes() {

        FrameScore[] frameScores = {
                new FrameScore(1, 2),
                new FrameScore(10),
                new FrameScore(10)
        };

        int score = new BowlingScoring(frameScores).accumulateScores();

        assertEquals(33, score);
    }

    @Test
    public void shouldCalculateBowlingScoreGivenArrayOfScoreWithSpare() {

        FrameScore[] frameScores = {
                new FrameScore(1, 2),
                new FrameScore(1, 9),
                new FrameScore(5, 2)
        };

        int score = new BowlingScoring(frameScores).accumulateScores();

        assertEquals(25, score);
    }

    @Test
    public void shouldCalculateBowlingScoreGivenArrayOfScoreWithStrikeAndFinalScore() {

        FrameScore[] frameScores = {
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(10),
                new FrameScore(10)
        };
        FinalScore finalScore = new FinalScore(9, 10);

        int score = new BowlingScoring(frameScores, finalScore).accumulateScores();

        assertEquals(74, score);
    }

    @Test
    public void shouldCalculateBowlingScoreGivenArrayOfScoreWithSpareInTheEnd() {

        FrameScore[] frameScores = {
                new FrameScore(1, 2),
                new FrameScore(5, 2),
                new FrameScore(1, 9)
        };

        int score = new BowlingScoring(frameScores).accumulateScores();

        assertEquals(20, score);
    }

    @Test
    public void shouldCalculateBowlingScoreGivenArrayOfScoreWithSpareAndFinalScore() {

        FrameScore[] frameScores = {
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(1, 1),
                new FrameScore(10),
                new FrameScore(1, 9)
        };
        FinalScore finalScore = new FinalScore(9);

        int score = new BowlingScoring(frameScores, finalScore).accumulateScores();

        assertEquals(55, score);
    }

    @Test
    public void shouldCalculateBowlingScoreGivenArrayOfScoreWithAllStrikes() {

        FrameScore[] frameScores = {
                new FrameScore(10),
                new FrameScore(10),
                new FrameScore(10),
                new FrameScore(10),
                new FrameScore(10),
                new FrameScore(10),
                new FrameScore(10),
                new FrameScore(10),
                new FrameScore(10),
                new FrameScore(10)
        };
        FinalScore finalScore = new FinalScore(10, 10);

        int score = new BowlingScoring(frameScores, finalScore).accumulateScores();

        assertEquals(300, score);
    }
}

  

