package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다이나믹 프로그래밍
 * Silver 3
 * 2xn 타일링
 * https://www.acmicpc.net/problem/11726
 */
public class BOJ_11726_2xn타일링 {
    private static final int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;

        int answer = dp[N];
        System.out.println(answer);
    }
}
