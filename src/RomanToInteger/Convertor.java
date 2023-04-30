package RomanToInteger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Convertor {
    public static int romanToInteger(String s){

        if (s.length() < 1 || s.length() > 15) {
            throw new IllegalArgumentException("string length is not valid");
        }

        Map<String, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put("I", 1);
        romanNumbers.put("V", 5);
        romanNumbers.put("X", 10);
        romanNumbers.put("L", 50);
        romanNumbers.put("C", 100);
        romanNumbers.put("D", 500);
        romanNumbers.put("M", 1000);

        if (
                s.contains("IIII") || s.contains("XXXX") || s.contains("CCCC") || s.contains("MMMM")
                        || s.contains("VV")|| s.contains("LL") || s.contains("DD")

        ) {
            throw new IllegalArgumentException("not a valid number");
        }

        if (
                !Arrays.stream(s.split("")).allMatch(
                        romanNumberFromInput -> Arrays.asList(
                                romanNumbers.keySet().toArray(new String[0])
                        ).contains(romanNumberFromInput)
                )
        ) {
            throw new IllegalArgumentException("not a valid number");
        }

        int result = 0;

        for (int i = 0;i < s.length(); i++) {

            String current = String.valueOf(s.charAt(i));

            String next = (i+1 >= s.length()) ? null : String.valueOf(s.charAt(i+1));

            if (next == null || romanNumbers.get(current) >= romanNumbers.get(next)) {
                result += romanNumbers.get(current);
            } else {
                result -= romanNumbers.get(current);
            }
        }

        if (result < 1 || result > 3999) {
            throw new IllegalArgumentException("out of range, it should be between 1 and 3999");
        }

        return result;
    }
}
