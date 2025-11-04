package leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/valid-word/description/
 */
public class Q3136_ValidWord {

    public static void main(String[] args) {
//        assertTrue(isValid("234Adas"));
//        assertFalse(isValid("b3"));
//        assertFalse(isValid("a3$e"));

        assertTrue(isValid("AhI"));
    }

    public static boolean isValid(String word) {
        boolean hasVowel = false, hasConsonant = false;

        // 1. It contains a minimum of 3 characters.
        if (word == null || word.length() < 3) return false;

        // 2. It contains only digits (0-9), and English letters (uppercase and lowercase).
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isDigit(c)) continue;
            else if (Character.isLetter(c)) {
                Character lower = Character.toLowerCase(c);
                // 3. It includes at least one vowel.
                if (isVowel(lower)) hasVowel = true;
                // 4. It includes at least one consonant.
                else hasConsonant = true;

            } else return false;

        }

        return hasVowel && hasConsonant;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
