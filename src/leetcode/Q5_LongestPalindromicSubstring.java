package leetcode;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Q5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        runTests(new Q5_LongestPalindromicSubstring()::longestPalindrome);
    }

    public static void runTests(Function<String, String> solution) {
        assertEquals("a", solution.apply("a"));
        assertEquals("aaaa", solution.apply("aaaa"));
        assertEquals("anana", solution.apply("bananas"));
        assertEquals("", solution.apply(""));

        String r1 = solution.apply("babad");
        assertTrue(r1.equals("bab") || r1.equals("aba"));

        String r2 = solution.apply("abcd");
        assertEquals(1, r2.length());
        assertTrue("abcd".contains(r2));

    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 중심이 한 문자 (aba)
            int length1 = expandFromCenter(s, i, i);
            // 중심이 두 문자 (abba)
            int length2 = expandFromCenter(s, i, i + 1);

            int length = Math.max(length1, length2);

            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}

