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
public class BOJ_14501_퇴사_DFS {
    private static int n, maxProfit = -1;
    private static int[] T, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        T = new int[n + 1];
        P = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        System.out.println(maxProfit);
    }

    private static void dfs(int index, int profix) {
        if (index >= n + 1) {
            maxProfit = Math.max(maxProfit, profix);
            return;
        }

        if (index + T[index] <= n + 1)
            dfs(index + T[index], profix + P[index]);
        else
            dfs(index + T[index], profix);
        dfs(index + 1, profix);
    }

}
