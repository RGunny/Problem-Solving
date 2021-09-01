package boj;

import java.io.*;

/**
 * 다이나믹 프로그래밍
 * Silver 3
 * 퇴사
 * https://www.acmicpc.net/problem/1003
 */
public class BOJ_1003_피보나치함수 {
    private static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(dp[n][0] + " " + dp[n][1] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int[] fibonacci(int n) {
        if(n == 0 || n == 1) return dp[n];

        else if (dp[n][0] == 0 || dp[n][1] == 0) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return dp[n];
    }

}
