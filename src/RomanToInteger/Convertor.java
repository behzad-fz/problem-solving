package RomanToInteger;

import java.util.Arrays;
import java.util.Map;

public class Convertor {
    private static final Map<String, Integer> ROMAN_NUMBERS = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );

    public static int romanToInteger(String s) {

        if (s.length() < 1 || s.length() > 15) {
            throw new IllegalArgumentException("string length is not valid");
        }

        if (
                s.matches(".*(I{4}|X{4}|C{4}|M{4}|V{2}|L{2}|D{2}).*") ||
                !Arrays.stream(s.split("")).allMatch(
                        romanNumberFromInput -> Arrays.asList(
                                ROMAN_NUMBERS.keySet().toArray(new String[0])
                        ).contains(romanNumberFromInput)
                )
        ) {
            throw new IllegalArgumentException("not a valid number");
        }

        int result = 0;

        for (int i = 0;i < s.length(); i++) {

            String current = String.valueOf(s.charAt(i));

            String next = (i+1 >= s.length()) ? null : String.valueOf(s.charAt(i+1));

            if (next == null || ROMAN_NUMBERS.get(current) >= ROMAN_NUMBERS.get(next)) {
                result += ROMAN_NUMBERS.get(current);
            } else {
                result -= ROMAN_NUMBERS.get(current);
            }
        }

        if (result < 1 || result > 3999) {
            throw new IllegalArgumentException("out of range, it should be between 1 and 3999");
        }

        return result;
    }
}
