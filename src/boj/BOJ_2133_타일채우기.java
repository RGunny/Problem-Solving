package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다이나믹 프로그래밍
 * Silver 1
 * 타일 채우기
 * https://www.acmicpc.net/problem/2133
 */
public class BOJ_2133_타일채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 2];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2)
                dp[i] += dp[j] * 2;
        }

        long answer = dp[N];
        System.out.println(answer);
    }
}
