package codility.lessons._3_time_complexity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Codility
 * Lessions 3 - Time Complexity
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium {

    public int solution(int[] A) {
        // |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
        int min = Integer.MAX_VALUE, left = 0, right = Arrays.stream(A).sum();
        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];

            min = min > Math.abs(left - right) ? Math.abs(left - right) : min;
        }

        return min;
    }

    @Test
    void test() {
        assertEquals(solution(new int[]{3, 1, 2, 4, 3}), 1);
    }
}
