package com.vf.bowling.tool;

import com.vf.bowling.exception.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.vf.bowling.tool.BowlingScoreParser.SPACE_SEPARATED;

public class ScoreStringValidator {

    public static final String DIGITS_AND_SPACE_ALLOWED = "^[\\d\\s]+$";

    public static void validate(String bowlingScoreString) throws InvalidInputException {

        Matcher matcher = Pattern.compile(DIGITS_AND_SPACE_ALLOWED).matcher(bowlingScoreString);
        if (!matcher.matches()) {
            throw new InvalidInputException("Bowling Scoring String contains invalid characters.");
        }

        if (containsNumberBiggerThanTen(bowlingScoreString)) {
            throw new InvalidInputException("Bowling Scoring String contains invalid digits.");
        }
    }

    private static boolean containsNumberBiggerThanTen(String bowlingScoreString) {
        boolean containsNumberBiggerThanTen = false;

        String[] values = bowlingScoreString.split(SPACE_SEPARATED);
        for (String value : values) {
            if (Integer.valueOf(value) > 10) {
                containsNumberBiggerThanTen = true;
                break;
            }
        }
        return containsNumberBiggerThanTen;
    }
}