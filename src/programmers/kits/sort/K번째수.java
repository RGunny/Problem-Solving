package programmers.kits.sort;

import java.util.Arrays;

/**
 * 정렬
 * Level 1
 * K번째수
 * https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
 */
public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int len = commands.length;

        int[] ans = new int[len];
        // command 수만큼 반복합니다.
        for (int i = 0; i < len; i++) {
            // slicing한 값을 넣어둘 임시 배열을 생성합니다.
            int[] temp = new int[commands[i][1] - commands[i][0] + 1];
            int idx = 0;

            // 1. 주어진 command대로 slicing합니다.
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                temp[idx++] = array[j];
            }

            // 2. Slicing한 배열을 정렬합니다.
            Arrays.sort(temp);

            // 3. 해당 command 턴의 답(k번째수)를 ans배열에 넣습니다.
            ans[i] = temp[commands[i][2] - 1];
        }

        for (int an : ans) {
            System.out.print(an + " ");
        }

    }

}
