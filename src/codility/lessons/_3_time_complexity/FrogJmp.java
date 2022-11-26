package codility.lessons._3_time_complexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Codility
 * Lessions 3 - Time Complexity
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJmp {

    public int solution(int X, int Y, int D) {
        // * one dimension
        // X : start
        // Y : goal (Y < = goal)
        // D : distance can go in one jump

        int distance = (Y - X);
        int count = (distance / D) + ((distance % D) > 0 ? 1 : 0);

        return count;
    }

    /**
     * Write an efficient algorithm for the following assumptions:
     *
     * X, Y and D are integers within the range [1..1,000,000,000];
     * X ≤ Y.
     */
    @Test
    void test() {
        assertEquals(solution(10, 85, 30), 3);
    }
}
