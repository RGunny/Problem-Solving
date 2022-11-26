package codility.lessons._3_time_complexity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Codility
 * Lessions 3 - Time Complexity
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
public class PermMissingElem {

    public int solution1(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        int missingElement = 0;
        for (int i = 1; i <= A.length + 1; i++) {
            if (!set.contains(i)) {
                missingElement = i;
                break;
            }
        }

        return missingElement;
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int missingElement = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                missingElement = i + 1;
                break;
            }
        }
        missingElement = missingElement == 0 ? A.length + 1 : missingElement;

        return missingElement;
    }

    @Test
    void test() {
        assertEquals(solution1(new int[]{2, 3, 1, 5}), 4);
        assertEquals(solution2(new int[]{2, 3, 1, 5}), 4);
    }
}
