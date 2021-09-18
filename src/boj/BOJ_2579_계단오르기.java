package boj;

import java.io.*;

/**
 * 다이나믹 프로그래밍
 * Silver 3
 * 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */
public class BOJ_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] steps = new int[N + 2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++)
            steps[i] = Integer.parseInt(br.readLine());

        dp[1] = steps[1];
        dp[2] = steps[2] + dp[1];

        for (int i = 3; i <= N; i++)
            dp[i] = Math.max(steps[i - 1] + dp[i - 3], dp[i - 2]) + steps[i];

        System.out.println(dp[N]);
    }
}
