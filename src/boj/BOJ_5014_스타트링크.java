package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS, BFS
 * Gold 5
 * 스타트링크
 * https://www.acmicpc.net/problem/5014
 */
public class BOJ_5014_스타트링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * Goal : S층 -> G층
         */
        int F = Integer.parseInt(st.nextToken()); // total floor
        int S = Integer.parseInt(st.nextToken()); // start floor
        int G = Integer.parseInt(st.nextToken()); // goal floor
        int U = Integer.parseInt(st.nextToken()); // up
        int D = Integer.parseInt(st.nextToken()); // down

        int answer = bfs(F, S, G, U, D);

        if(answer < 0) System.out.println("use the stairs");
        else System.out.println(answer);
    }

    private static int bfs(int F, int S, int G, int U, int D) {

        Queue<Floor> q = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];

        q.add(new Floor(S, 0));
        visited[S] = true;

        while (!q.isEmpty()) {

            Floor floor = q.poll();

            if(floor.cur == G) return floor.cost;

            if (floor.cur + U <= F && !visited[floor.cur + U]) {
                q.add(new Floor(floor.cur + U, floor.cost + 1));
                visited[floor.cur + U] = true;
            }

            if (floor.cur - D >= 1 && !visited[floor.cur - D]) {
                q.add(new Floor(floor.cur - D, floor.cost + 1));
                visited[floor.cur - D] = true;
            }

        }

        return -1;
    }

    private static class Floor {
        int cur, cost;

        public Floor(int cur, int cost) {
            this.cur = cur;
            this.cost = cost;
        }
    }

}
