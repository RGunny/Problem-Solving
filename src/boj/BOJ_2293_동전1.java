package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍
 * Silver 1
 * 동전 1
 * https://www.acmicpc.net/problem/2293
 */
public class BOJ_2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());

        // index원까지 동전 갯수의 경우의 수
        // dp[i] = 이전 동전까지 활용하여 누적시킨 경우의 수 + 현재 동전을 사용하여 만들 수 있는 경우의 수
        // dp[i] = dp[i] + dp[i - coin]
        int[] dp = new int[K + 1];

        dp[0] = 1;

        for(int i = 0; i < N; i++) {
            for(int j = coins[i]; j <= K; j++)
                dp[j] += dp[j - coins[i]];
        }

        System.out.println(dp[K]);
    }
}
