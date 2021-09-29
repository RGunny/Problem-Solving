package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다이나믹 프로그래밍
 * Silver 2
 * 1, 2, 3 더하기 3
 * https://www.acmicpc.net/problem/15988
 */
public class BOJ_15988_123더하기3 {
    private static final int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[N + 3];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= N; i++)
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;

            System.out.println(dp[N]);

        }
    }
}
