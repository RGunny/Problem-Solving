package programmers.practice.level3;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
public class 최고의집합 {

    public static void main(String[] args) {
        solution(2, 9); // [4, 5]
        solution(2, 1); // [-1]
        solution(2, 8); // [4, 4]


    }

    public static int[] solution(int n, int s) {

        if(s < n) return new int[]{-1};

        int[] answer = new int[n];
        Arrays.fill(answer, s/n);

        for (int i = 0; i < s % n; i++) {
            answer[i]++;
        }

        Arrays.sort(answer);

        return answer;
    }
}
