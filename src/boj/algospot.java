package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1261
 * Gold 4
 * 알고 스팟
 * https://www.acmicpc.net/problem/1261
 */
public class algospot {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int r, c, minNum;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        getMinNum();
        System.out.println("minNum = " + minNum);
    }

    private static void getMinNum() {
        Queue<Point> q = new LinkedList<>();
        minNum = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        q.add(new Point(0, 0, 0, visited));

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                Point cur = q.poll();
                int curR = cur.r;
                int curC = cur.c;
                int num = cur.num;
//                System.out.println(curR + " " + curC + " num: " + num);
                boolean[][] curVisited = cur.visited;

                if (curR == r - 1 && curC == c - 1) {
                    minNum = Math.min(minNum, num);
                }

                for (int j = 0; j < 4; j++) {
                    int nr = curR + dir[j][0];
                    int nc = curC + dir[j][1];

                    if (!isRange(nr, nc)) continue;
                    if (curVisited[nr][nc]) continue;

                    if (map[nr][nc] == 1) {
                        curVisited[nr][nc] = true;
                        q.add(new Point(nr, nc, num + 1, curVisited));
//                        System.out.println(nr + " " +  nc + " num: " + num);
                    } else {
                        curVisited[nr][nc] = true;
                        q.add(new Point(nr, nc, num, curVisited));
                        System.out.println(nr + " " +  nc + " num: " + num);
                    }

                }
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c;
    }

    private static class Point {
        int r, c, num;
        boolean[][] visited;

        public Point(int r, int c, int num, boolean[][] visited) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.visited = visited;
        }
    }
}
