package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍
 * Silver 2
 * 상자넣기
 * https://www.acmicpc.net/problem/1965
 */
public class BOJ_1965_상자넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] boxes = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            boxes[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        int max = -1;
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++)
                if (boxes[j] < boxes[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            max = max < dp[i] ? dp[i] : max;
        }

        System.out.println(max);
    }
}
