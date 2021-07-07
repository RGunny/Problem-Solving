package programmers.kits.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 동적 프로그래밍
 * Level 3
 * N으로 표현
 * https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
 */
public class N으표현_DP {
    public static void main(String[] args) {
        int N = 5;
        int number = 31168;

        Set<Integer>[] dp = initDp(N, number);
        dp = dp(dp);
        int min = getMin(dp, number);

        for (int i = 0; i < dp.length; i++) {
            System.out.println("dp[" + i + "] = " + dp[i]);
        }
        System.out.println("min = " + min);
    }

    /**
     * Set<Integer> Array 를 초기화하는 메서드
     * => 1 ~ 8 까지의 인덱스에 N, NN, NNN ... N*N 초기화
     */
    private static Set<Integer>[] initDp(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        int temp = N;

        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(temp);
            temp = temp * 10 + N;
        }

        return dp;
    }

    /**
     * DP 연산을 하는 메서드
     * <p>
     * => 1 ~ 9까지
     */
    private static Set<Integer>[] dp(Set<Integer>[] dp) {

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (Integer a : dp[j]) {
                    for (Integer b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(b - a);
                        dp[i].add(a * b);
                        if (b != 0) {
                            dp[i].add(a / b);
                        }
                        if (a != 0) {
                            dp[i].add(b / a);
                        }
                    }
                }
            }
        }

        return dp;
    }

    private static int getMin(Set<Integer>[] dp, int number) {
        int min = -1;

        for (int i = 1; i < 9; i++) {
            if (dp[i].contains(number)) {
                min = i;
                break;
            }
        }

        return min;
    }
}
