package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다이나믹 프로그래밍
 * Silver 3
 * 파도반 수열
 * https://www.acmicpc.net/problem/9461
 */
public class BOJ_9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[N + 2];
            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i <= N; i++)
                dp[i] = dp[i - 2] + dp[i - 3];

            sb.append(dp[N] + "\n");
        }

        System.out.println(sb.toString());
    }
}
