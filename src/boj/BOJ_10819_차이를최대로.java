package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS
 * Silver 2
 * 차이를 최대로
 * https://www.acmicpc.net/problem/10819
 */
public class BOJ_10819_차이를최대로 {
    private static int N, max = Integer.MIN_VALUE;
    private static int[] nums;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, new int[N]);

        System.out.println(max);

    }

    private static int getMax(int[] selected) {
        int sum = 0;
        for (int i = 0; i < N - 1; i++)
            sum += Math.abs(selected[i] - selected[i + 1]);

        return sum;
    }

    private static void dfs(int depth, int[] selected) {

        if (depth >= N) {
            int selectedSum = getMax(selected);
            max = max > selectedSum ? max : selectedSum;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[depth] = nums[i];
            dfs(depth + 1, selected);
            visited[i] = false;
        }
    }
}
