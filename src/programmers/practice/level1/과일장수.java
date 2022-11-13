package programmers.practice.level1;

import java.util.Arrays;
import java.util.Collections;

public class 과일장수 {

    public static void main(String[] args) {
//        int k = 3;
//        int m = 4;
//        int[] score = {1, 2, 3, 1, 2, 3, 1}; // 8
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}; // 33

//        Arrays.sort(Arrays.stream(score).boxed().toArray(Integer[]::new), Comparator.reverseOrder());
        int answer = 0;

        score = Arrays.stream(score)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        int numberOfBox = score.length / m;
        for(int i=1; i<=numberOfBox; i++){
            answer += calcBoxScore(score[i * m - 1], m);
        }
        System.out.println("answer = " + answer);
    }

    private static int calcBoxScore(int lowestScore, int m){
        return lowestScore * m;
    }
}
