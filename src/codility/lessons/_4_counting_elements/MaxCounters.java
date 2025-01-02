package codility.lessons._4_counting_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Codility
 * Lessions 4 - Counting Elements
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0; // 현재 최대 값
        int maxCounter = 0; // max counter 기준값

        for (int operation : A) {
            if (operation >= 1 && operation <= N) {
                // 특정 카운터 증가
                if (counters[operation - 1] < maxCounter) {
                    counters[operation - 1] = maxCounter + 1;
                } else {
                    counters[operation - 1]++;
                }
                max = Math.max(max, counters[operation - 1]);
            } else if (operation == N + 1) {
                // max counter 연산
                maxCounter = max;
            }
        }

        // maxCounter lazy write 동기화
        for (int i = 0; i < N; i++) {
            if (counters[i] < maxCounter) {
                counters[i] = maxCounter;
            }
        }

        return counters;
    }

    @Test
    void test() {
        // 테스트 케이스 1: 기본적인 증가 연산
        assertArrayEquals(new int[]{1, 0, 0}, solution(3, new int[]{1}));
        // 테스트 케이스 2: 여러 카운터 증가
        assertArrayEquals(new int[]{1, 1, 0}, solution(3, new int[]{1, 2}));
        // 테스트 케이스 3: 최대값 동기화 연산
        assertArrayEquals(new int[]{1, 1, 1}, solution(3, new int[]{1, 2, 4}));
        // 테스트 케이스 4: 최대값 동기화 후 증가 연산
        assertArrayEquals(new int[]{2, 1, 1}, solution(3, new int[]{1, 2, 4, 1}));
        // 테스트 케이스 5: 모든 카운터 최대값 동기화
        assertArrayEquals(new int[]{2, 2, 2}, solution(3, new int[]{1, 2, 4, 1, 4})); }

}
