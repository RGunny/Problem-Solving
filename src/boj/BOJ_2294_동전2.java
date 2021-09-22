package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍
 * Silver 1
 * 동전 2
 * https://www.acmicpc.net/problem/2294
 */
public class BOJ_2294_동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());

        // index원을 만들기 위해 사용한 최소 동전 갯수
        // dp[i] = min(이전 동전까지 사용해 만든 인덱스원까지 최소값, dp[현재 계산할 원 - 동전의 가치] + 1)
        // dp[현재 계산할 원 - 동전의 가치] + 1 : 현재 동전을 뺀 값에 필요한 최소 동전 갯수 + 현재 동전 1개
        int[] dp = new int[K + 1];

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++)
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }

        int answer = dp[K] == 10001 ? -1 : dp[K];
        System.out.println(answer);

    }
}
