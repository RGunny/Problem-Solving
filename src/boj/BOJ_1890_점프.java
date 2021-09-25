package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍
 * Silver 2
 * 점프
 * https://www.acmicpc.net/problem/1890
 */
public class BOJ_1890_점프 {
    private static final int[][] dir = {{0, 1}, {1, 0}}; // right, down

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N + 1][N + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == N && j == N) break;

                int right = j + map[i][j];
                int down = i + map[i][j];

                if(right <= N)
                    dp[i][right] += dp[i][j];

                if(down <= N)
                    dp[down][j] += dp[i][j];

            }
        }

        System.out.println(dp[N][N]);
    }
}
