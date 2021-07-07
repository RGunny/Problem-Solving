package programmers.kits.sort;

import java.util.Arrays;

/**
 * 정렬
 * Level 2
 * H-Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        Arrays.sort(citations);
        int len = citations.length;
        int median = len / 2;
        int temp = len - median;
        for (int i = median; i >= 0; i--) {
            if (citations[i] >= temp) {
                temp += 1;
            } else {
                break;
            }
        }
        System.out.println(temp - 1);
    }

    private static void ver2() {
        int[] citations = {3, 0, 6, 1, 5};

        // 1. Sort ascending
        Arrays.sort(citations);

        int max = 0;
        int len = citations.length;
        for (int i = len - 1; i > -1; i--) {
            int min = (int) Math.min(citations[i], len - i);
            if (max < min) max = min;
        }

        System.out.println("hIndex = " + max);

    }

    private static void ver1() {
        int[] citations = {3, 0, 6, 1, 5};

        int hIndex = 0;
        int len = citations.length;

        // 1. Sort ascending
        Arrays.sort(citations);
        for (int i = 0; i < len; i++) {
            // 2. 마지막 인덱스부터 검사
            int h = len - i;

            // 3. 최댓값이라면 종료
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        System.out.println("hIndex = " + hIndex);
    }
}
