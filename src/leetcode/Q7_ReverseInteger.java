package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Q7_ReverseInteger {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
        assertEquals(21, reverse(120));
        assertEquals(0, reverse(0));
        // MIN, 초과/미만은 0
        assertEquals(0, reverse(Integer.MIN_VALUE));
        // 초과 케이스
        assertEquals(0, reverse(1999999999));
    }

    /**
     * !!! 32 bit Integer 벗어나면 0 반환
     */
    public static int reverse(int x) {

        int reverse = 0;

        while (x != 0) {
            int pop = x % 10; // 마지막 자리 추출 (음수면 음수 추출됨)
            x /= 10; // 마지막 자릿수 제거

            // 1. 양수 overflow 확인, 끝자리 제외 보다 크면 반환
            if (reverse > Integer.MAX_VALUE / 10) return 0;
            // 2. 양수 overflow 확인(경계), 끝자리 제외 일치하면 끝자리 > 7 확인
            if (reverse == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            // 3. 음수 overflow 확인, 끝자리 제외 보다 작으면 반환
            if (reverse < Integer.MIN_VALUE / 10) return 0;
            // 4. 음수 overflow 확인(경계), 끝자리 제외 일치하면 끝자리 < -8 확인
            if (reverse == Integer.MIN_VALUE / 10 && pop < -8) return 0;

            reverse = reverse * 10 + pop;
        }

        return reverse;
    }
}
