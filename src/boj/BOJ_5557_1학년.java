package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DP
 * Gold 5
 * 1학년
 * https://www.acmicpc.net/problem/5557
 */
public class BOJ_5557_1학년 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            number[i] = Integer.parseInt(st.nextToken());


        long[][] dp = new long[N][21];
        dp[1][number[1]] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if(dp[i-1][j] == 0) continue;

                if(j + number[i] <= 20) dp[i][j + number[i]] += dp[i - 1][j];
                if(j - number[i] >= 0) dp[i][j - number[i]] += dp[i - 1][j];
            }
        }

        System.out.println(dp[N-1][number[N]]);
    }
}
