package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다이나믹 프로그래밍
 * Silver 1
 * 1, 2, 3 더하기 3
 * https://www.acmicpc.net/problem/15989
 */
public class BOJ_15989_123더하기4 {
    private static long[][] dp = new long[10001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        getDp();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N][1] + dp[N][2] + dp[N][3] + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void getDp() {

        dp[1][1] = 1; // 1
        dp[2][1] = 1; // 1 + 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 1 + 1 + 1
        dp[3][2] = 1; // 1 + 2
        dp[3][3] = 1; // 3

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

    }
}
