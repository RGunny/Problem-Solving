package codility.lessons._4_counting_elements;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Codility
 * Lessions 4 - Counting Elements
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */
public class FrogRiverOne {

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();

        int minTime = -1;
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) {
                minTime = i;
                break;
            }
        }
        return minTime;
    }

    @Test
    void test() {
        assertEquals(solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}), 6);
    }
}
