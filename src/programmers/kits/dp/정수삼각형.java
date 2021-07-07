package programmers.kits.dp;

import java.io.IOException;
import java.util.Arrays;

/**
 * 동적 프로그래밍
 * Level 3
 * 정수 삼각형
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */
public class 정수삼각형 {
    private static int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    private static int maxSum = Integer.MIN_VALUE;
    private static int len = triangle.length;

    public static void main(String[] args) throws IOException {

        dfs(0, 0, triangle[0][0]);

        System.out.println("maxSum = " + maxSum);

        System.out.println("dp(triangle, len) = " + dp(triangle, len));
        System.out.println("dpVer2(triangle, len) = " + dpVer2(triangle, len));
    }

    private static int dpVer2(int[][] triangle, int len) {
        for (int i = 1; i < len; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];

            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
        }

        return Arrays.stream(triangle[len - 1]).max().getAsInt();
    }

    private static int dp(int[][] triangle, int len) {
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {

            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }

        }

        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            max = Math.max(dp[dp.length - 1][i], max);
        }

        return max;
    }

    private static void dfs(int r, int c, int sum) {

        if (r == len - 1) {
            maxSum = sum > maxSum ? sum : maxSum;
            return;
        }

        dfs(r + 1, c, sum + triangle[r + 1][c]);
        dfs(r + 1, c + 1, sum + triangle[r + 1][c + 1]);

    }
}
