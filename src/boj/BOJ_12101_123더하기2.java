package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍
 * Silver 1
 * 1, 2, 3 더하기 2
 * https://www.acmicpc.net/problem/12101
 */
public class BOJ_12101_123더하기2 {
    private static int[] dp;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

        dfs(N, K);
        System.out.println(sb.toString());
    }

    private static void dfs(int N, int K) {
        if (dp[N] < K) {
            sb.append(-1);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (dp[N - i] >= K) {

                if (N - i > 0) {
                    sb.append(i + "+");
                    dfs(N - i, K);
                } else
                    sb.append(i);
                break;
            }
            K -= dp[N - i];
        }
        return;
    }
}
