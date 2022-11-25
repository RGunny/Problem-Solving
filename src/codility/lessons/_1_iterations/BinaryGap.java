package codility.lessons._1_iterations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Codility
 * Lessions 1 - Itertaions
 * https://app.codility.com/programmers/lessons/1-iterations/
 */
public class BinaryGap {

    private int solution(int N) {
        String binary = Integer.toBinaryString(N);
        int binaryGap = getBinaryGap(binary);

        return binaryGap;
    }

    private int getBinaryGap(String binary) {
        int count = 0, maxCount = 0;

        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '0') ++count;
            else {
                maxCount = count > maxCount ? count : maxCount;
                count = 0;
            }
        }
        return maxCount;
    }

    @Test
    void test() {
        assertEquals(solution(1041), 5);
        assertEquals(solution(32), 0);
        assertEquals(solution(9), 2);
        assertEquals(solution(529), 4);
        assertEquals(solution(20), 1);
        assertEquals(solution(15), 0);
        assertEquals(solution(2147483647), 0);
    }
}
