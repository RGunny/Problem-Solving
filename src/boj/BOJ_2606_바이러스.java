package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS, BFS
 * Silver 3
 * 바이러스
 * https://www.acmicpc.net/problem/2606
 */
public class BOJ_2606_바이러스 {
    private static boolean[][] computers;
    private static boolean[] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        computers = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a][b] = true;
            computers[b][a] = true;
        }

//        int answer = bfs(N);
//        System.out.println(answer);
        dfs(1, N);
        System.out.println(count);
    }

    private static void dfs(int depth, int N) {
        if (visited[depth]) return;

        visited[depth] = true;

        for (int i = 1; i <= N; i++) {
            if (!computers[depth][i] || visited[i]) continue;
            count++;
            dfs(i, N);
        }
    }

    private static int bfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < N; i++) {
                if (!computers[cur][i] || visited[i]) continue;
                q.add(i);
                visited[i] = true;
                cnt++;
            }

        }
        return cnt;
    }


}
