package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DP
 * Platinum 4
 * 집배원 한상덕
 * https://www.acmicpc.net/problem/2842
 */
public class BOJ_2842_집배원한상덕 {
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // 상 하 좌 우 좌상 우상 좌하 우하
    private static int N, altitudeMap[][];
    private static int sr, sc, kNum, minFatigue = Integer.MAX_VALUE;
    private static char[][] map;
    private static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        altitudeMap = new int[N][N]; // 고도

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'P') {
                    sr = i;
                    sc = j;
                } else if (map[i][j] == 'K')
                    kNum++;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                altitudeMap[i][j] = Integer.parseInt(st.nextToken());
                treeSet.add(altitudeMap[i][j]);
            }
        }

        bfs();

        System.out.println(minFatigue);
    }

    private static void bfs() {

        Integer[] altitude = treeSet.toArray(new Integer[]{}); // 오름차순 정렬된 중복 없는 고도
        int min = 0, max = 0;

        while (min <= max && max < altitude.length) {

            Queue<Point> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            int count = 0;

            // 시작 지점 고도는 투 포인터 시작(최저고도) ~ 끝(최대고도)
            if (altitudeMap[sr][sc] >= altitude[min] && altitudeMap[sr][sc] <= altitude[max]) {
                q.add(new Point(sr, sc));
                visited[sr][sc] = true;
            }

            while (!q.isEmpty()) {

                Point cur = q.poll();

                for (int d = 0; d < 8; d++) {
                    int nr = cur.r + dir[d][0];
                    int nc = cur.c + dir[d][1];

                    if (!isRange(nr, nc)) continue;
                    if (visited[nr][nc]) continue;

                    // 다음 위치 고도가 최저고도보다 작거나 최대고도보다 작으면
                    if (altitude[min] > altitudeMap[nr][nc] || altitude[max] < altitudeMap[nr][nc]) continue;

                    if (map[nr][nc] == 'K') count += 1;

                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }

            if (count == kNum) {
                minFatigue = Math.min(minFatigue, altitude[max] - altitude[min]);
                min++;
            }
            else max++;

        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }

    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}