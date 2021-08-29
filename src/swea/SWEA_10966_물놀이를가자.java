package swea;

import java.io.*;
import java.util.*;

public class SWEA_10966_물놀이를가자 {
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    private static int N, M;
    private static List<Point> waters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            waters = new LinkedList<>();

            int[][] dist = new int[N][M];
            for (int i = 0; i < N; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'W')
                        waters.add(new Point(i, j));
                }
            }

            bfs(map, dist);
            int minDist = getMinDist(dist);
           bw.write("#" +  tc + " " + minDist + "\n");
        }
        bw.close();
        br.close();
    }

    private static int[][] bfs(char[][] map, int[][] dist) {

        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (Point water : waters) {
            q.add(new Point(water.r, water.c));
            visited[water.r][water.c] = true;
        }

        int count = 1;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                int r = cur.r;
                int c = cur.c;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];

                    if (!isRange(nr, nc) || visited[nr][nc] || map[nr][nc] == 'W') continue;
                    if (dist[nr][nc] < dist[r][c]) continue;

                    dist[nr][nc] = count;
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
            count++;
        }
        return dist;
    }

    private static int getMinDist(int[][] dist) {
        int minDist = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(dist[i][j] == Integer.MAX_VALUE) continue;
                minDist += dist[i][j];
            }
        }
        return minDist;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }

    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
