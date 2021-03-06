package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍
 * Silver 2
 * 스티커
 * https://www.acmicpc.net/problem/9465
 */
public class BOJ_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++)
                    stickers[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int i = 2; i <= N; i++) {
                // 1, 2 후의 인덱스인 대각선
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
