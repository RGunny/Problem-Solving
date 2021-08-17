package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍, 그리디
 * Gold 2
 * 짝수 팰린드롬
 * https://www.acmicpc.net/problem/21925
 */
public class BOJ_21925_짝수팰린드롬_DP {
    private static int N, dp[], sequence[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 수열 A의 길이

        sequence = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            sequence[i] = Integer.parseInt(st.nextToken());

        getEvenPalindrome(0);

        System.out.println(dp[0]);
    }

    private static int getEvenPalindrome(int index) {

        if (index >= N)
            return 0;

        if (dp[index] != 0)
            return dp[index];

        int cur = -1;

        for (int i = index + 1; i < N; i += 2) {

            boolean isPalindrome = true;

            for (int j = 0; j <= (i - index) / 2; j++) {

                if (sequence[index + j] != sequence[i - j]) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {

                int value = getEvenPalindrome(i + 1);
                if (value == -1) continue;

                cur = Math.max(cur, value + 1);
            }
        }

        return dp[index] = cur;
    }
}
