package programmers.kits.dp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 동적 프로그래밍
 * Level 3
 * 등굣길
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */
public class 등굣길_BFS_시간초과 {
    private static int[][] dir = {{0, 1}, {1, 0}};
    private static int r, c;

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        r = n;
        c = m;

        int[][] map = initMap(puddles);

        int numOfMinDist = bfs(map);

        System.out.println(numOfMinDist % 1000000007);
    }

    private static int bfs(int[][] map) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        int count = 0;

        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Point cur = q.poll();

                for (int d = 0; d < 2; d++) {
                    int nr = cur.r + dir[d][0];
                    int nc = cur.c + dir[d][1];

                    if(nr == r && nc == c) count += 1;
                    if (!isRange(nr, nc)) continue;

                    if (map[nr][nc] == 1) continue;

                    q.add(new Point(nr, nc));
                }

            }

            if (count > 0) break;
        }

        return count;


    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 1 && nr <= r && nc >= 1 && nc <= c;
    }

    private static int[][] initMap(int[][] puddles) {
        int[][] map = new int[r + 1][c + 1];

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = 1; // 물에 잠긴 지역 (puddlies 행렬 주의)
        }

        return map;
    }

    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
