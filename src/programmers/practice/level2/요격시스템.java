package programmers.practice.level2;

import java.util.Arrays;

public class 요격시스템 {

    public static void main(String[] args) {
        solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}); // 3
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        // {s, e} 끝 값에서는 요격 불가능
        // 최솟값구하기
//        Arrays.sort(targets, Comparator.comparingInt((int[] arr) -> arr[1]));
        Arrays.sort(targets, ((o1, o2) -> o1[1] - o2[1]));

        int min = Integer.MIN_VALUE;

        for (int[] target : targets) {
            if (min < target[0]) {
                min = target[1] - 1;
                answer++;
            }
        }

        return answer;
    }
}
