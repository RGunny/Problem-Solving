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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        computers = new boolean[N][N];
        visited = new boolean[N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            computers[a][b] = true;
            computers[b][a] = true;
        }

        int answer = bfs(N);
        System.out.println(answer);
    }

    private static int bfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < N; i++) {
                if (!computers[cur][i] || visited[i]) continue;
                q.add(i);
                visited[i] = true;
                count++;
            }

        }
        return count;
    }


}
