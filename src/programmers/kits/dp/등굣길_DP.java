package programmers.kits.dp;

import java.util.Arrays;

/**
 * 동적 프로그래밍
 * Level 3
 * 등굣길
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */
public class 등굣길_DP {
    public static void main(String[] args) {
//        int m = 4;
//        int n = 3;
        int m = 100;
        int n = 100;
//        int[][] puddles = {{2, 2}};
        int[][] puddles = {{0, 0}};

        int[][] dp = new int[n + 1][m + 1];
        Arrays.stream(puddles).forEach(puddle -> dp[puddle[1]][puddle[0]] = -1);
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (dp[i][j] == -1) { // 침수된 지역
                    dp[i][j] = 0;
                    continue;
                }

                if (i != 1) dp[i][j] += dp[i - 1][j] % 1000000007;
                if (j != 1) dp[i][j] += dp[i][j - 1] % 1000000007;
            }
        }

        System.out.println(dp[n][m]);
        System.out.println(dp[n][m] % 1000000007);
    }
}
