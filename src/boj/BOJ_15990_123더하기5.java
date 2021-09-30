package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다이나믹 프로그래밍
 * Silver 2
 * 1, 2, 3 더하기 5
 * https://www.acmicpc.net/problem/15990
 */
public class BOJ_15990_123더하기5 {
    private static final int MOD = 1000000009;
    private static long[][] dp = new long[100001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        make();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sb.append((dp[N][1] + dp[N][2] + dp[N][3]) % MOD + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void make() {
        
        // 마지막 더한 숫자 기준 인덱스(1 ~ 3)
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 2 + 1
        dp[3][2] = 1; // 1 + 2
        dp[3][3] = 1; // 3

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

    }
}
