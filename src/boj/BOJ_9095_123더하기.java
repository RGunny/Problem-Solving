package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다이나믹 프로그래밍
 * Silver 3
 * 1, 2, 3 더하기
 * https://www.acmicpc.net/problem/9095
 */
public class BOJ_9095_123더하기 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
//            int[] dp = new int[N + 3];
            dp = new int[N + 3];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= N; i++)
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

//            getDp(N);

            System.out.println(dp[N]);
        }
    }

    private static int getDp(int N) {
        if(dp[N] > 0) return dp[N];
        if(N == 0) return 0;
        if(N == 1) return 1;
        if(N == 2) return 2;

        dp[N] = getDp(N - 1) + getDp(N - 2) + getDp(N - 3);

        return dp[N];
    }
}

