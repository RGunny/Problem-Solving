package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DP
 * Gold 5
 * 출근 경로
 * https://www.acmicpc.net/problem/5569
 */
public class BOJ_5569_출근경로 {
    private static final int mod = 100000;
    private static int w, h;
    private static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // dp[w][h][d][possible]
        // d: 0 -> west, 1 -> north
        // possible: 0 -> turn impossible, 1 -> turn possible
        dp = new int[w + 1][h + 1][2][2];

        for (int i = 2; i <= w; i++) dp[i][1][0][0] = 1;
        for (int i = 2; i <= h; i++) dp[1][i][1][0] = 1;

        for (int i = 2; i <= w; i++) {
            for (int j = 2; j <= h; j++) {
                dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % mod;
                dp[i][j][1][0] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1]) % mod;
                dp[i][j][0][1] = dp[i - 1][j][1][0];
                dp[i][j][1][1] = dp[i][j - 1][0][0];
            }
        }

        int route = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                route += dp[w][h][i][j];

        System.out.println(route % mod);
    }

}
