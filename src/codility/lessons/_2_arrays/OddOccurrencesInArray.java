package codility.lessons._2_arrays;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Codility
 * Lessions 2 - Arrays
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.computeIfPresent(A[i], (k, v) -> v + 1);
            map.computeIfAbsent(A[i], v -> 1);
        }

        int odd = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            odd = (entry.getValue() % 2 == 0) ? odd : entry.getKey();
        }

        return odd;
    }

    /**
     * Write an efficient algorithm for the following assumptions:
     *
     * N is an odd integer within the range [1..1,000,000];
     * each element of array A is an integer within the range [1..1,000,000,000];
     * all but one of the values in A occur an even number of times.
     */
    @Test
    void test() {
        assertEquals(solution(new int[]{9,3,9,3,9,7,9}), 7);
    }

}
