package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍, 브루트포스 알고리즘
 * Silver 4
 * 퇴사
 * https://www.acmicpc.net/problem/14501
 */
public class BOJ_14501_퇴사_DP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        // dp : N일에 얻을 수 있는 최대 수익
        int[] dp = new int[n + 2];
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int maxProfit = calcMaxProfit(n, T, P, dp);

        System.out.println(maxProfit);
    }

    private static int calcMaxProfit(int n, int[] T, int[] P, int[] dp) {

        for (int i = 1; i <= n; i++) {
            // 다음 날을 현재 날짜와 비교하여 최대값을 갱신
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 현재 날짜에서 소요시간을 더한 값이 N + 1(퇴사 날)을 넘기는 경우
            if (i + T[i]  > n + 1) continue;

            // 1. 현재 날짜에서 현재 일정 소요 시간을 더한 날(현재 주어진 소요 시간이 끝나는 날)에
            // 2. 현재 날짜에서의 최대 이득과 현재 일정 이득으로 얻을 이득을 더한 값과
            // 3. 1의 날짜에 잡혀있던 최대 이득을 비교하여 최대값을 넣습니다.
            dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
        }

        return dp[n + 1];
    }

}
