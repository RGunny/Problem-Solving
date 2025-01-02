package codility.lessons._4_counting_elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *  Codility
 *  Lessions 4 - Counting Elements
 *  https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 */
public class PermCheck {

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        int length = A.length;

        for (int num : A) {
            // 값이 범위를 벗어나거나 중복된 경우
            if (num < 1 || num > length || set.contains(num)) {
                return 0;
            }
            set.add(num);
        }

        return 1;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{4,1,3,2}), 1);
        Assertions.assertEquals(solution(new int[]{4,1,3}), 0);
    }
}
