package test.com.vf.bowling.tool;

import com.vf.bowling.model.FinalScore;
import com.vf.bowling.model.FrameScore;
import com.vf.bowling.tool.BowlingScoreParser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BowlingScoreParserTest {

    @Test
    public void shouldReturnTenFrameScoresAndFinalScoreGivenCompleteBowlingScoreString() {
        ArrayList<?> result = BowlingScoreParser.parse("10 10 10 10 10 10 10 10 10 10 10 10");

        assertEquals(2, result.size());
        assertEquals(10, convertObjectToFrameScoreList(result.get(0)).length);
        assertEquals(10, ((FinalScore) result.get(1)).firstScore());
        assertEquals(20, ((FinalScore) result.get(1)).score());
    }

    @Test
    public void shouldReturnTenFrameScoresAndFinalScoreGivenCompleteBowlingButNotAllTensScoreString() {
        ArrayList<?> result = BowlingScoreParser.parse("7 2 10 8 1 10 4 4 10 10 10 10 10 10 10");

        assertEquals(2, result.size());
        assertEquals(10, convertObjectToFrameScoreList(result.get(0)).length);
        assertEquals(10, ((FinalScore) result.get(1)).firstScore());
        assertEquals(20, ((FinalScore) result.get(1)).score());
    }

    @Test
    public void shouldReturnTenFrameScoresAndFinalScoreGivenCompleteBowlingWithOneAdditionalFinalScore() {
        ArrayList<?> result = BowlingScoreParser.parse("7 2 10 8 1 10 4 4 10 10 10 10 10 9");

        assertEquals(2, result.size());
        assertEquals(10, convertObjectToFrameScoreList(result.get(0)).length);
        assertEquals(9, ((FinalScore) result.get(1)).firstScore());
        assertEquals(9, ((FinalScore) result.get(1)).score());
    }

    @Test
    public void shouldReturnTenFrameScoresAndFinalScoreGivenCompleteBowlingWithoutFinalScore() {
        ArrayList<?> result = BowlingScoreParser.parse("7 2 10 8 1 4 4 10");

        assertEquals(2, result.size());
        assertEquals(5, convertObjectToFrameScoreList(result.get(0)).length);
        assertNull(result.get(1));
    }

    private FrameScore[] convertObjectToFrameScoreList(Object object) {
        Object[] objects = (Object[]) object;
        return Arrays.copyOf(objects, objects.length, FrameScore[].class);
    }
}
