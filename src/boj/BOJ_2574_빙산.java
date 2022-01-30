package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS, BFS
 * Gold 4
 * 빙산
 * https://www.acmicpc.net/problem/2573
 */
public class BOJ_2574_빙산 {
    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    private static int N, M;
    private static int[][] iceberg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // row
        M = Integer.parseInt(st.nextToken()); // col

        iceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                iceberg[i][j] = Integer.parseInt(st.nextToken());
        }

        int time = solve();
        System.out.println(time);
    }

    private static int solve() {
        int time = 0;

        while (true) {
            // 1. 빙산이 녹는다. (동서남북 0의 갯수만큼)
            // (차례대로 녹는 것이 아닌, 한 스탭에 한 번에 모두 녹아야 함) => 배열을 복제하여 해당 배열에서 비교한 후 원본 배열에서만 빙산을 녹임
            melt();
            time++;

            // 2.1 두 덩이 이상의 빙산이 되었는 지 확인한다.
            int theNumberOfIceberg = getIcebergNums();

            // 2.2 두 덩이 이상이 되었다면, 해당 년을 반환하고 종료한다.
            // 2.3 0덩이가 되었다면 실패하였으므로 0을 반환하고 종료한다.
            if (theNumberOfIceberg > 1) {
                break;
            } else if (theNumberOfIceberg == 0) {
                time = 0;
                break;
            }
        }
        return time;
    }

    private static void melt() {
        int[][] copy = copy(iceberg);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] <= 0) continue;

                q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int count = 0;
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + DIR[d][0];
                int nc = cur[1] + DIR[d][1];

                if (!isRange(nr, nc) || copy[nr][nc] > 0) continue;
                count++;
            }
            iceberg[cur[0]][cur[1]] = iceberg[cur[0]][cur[1]] > count ? iceberg[cur[0]][cur[1]] - count : 0;
        }
    }

    /*
        기존 한 덩어리의 빙산이 두 개 이상의 빙산으로 분리되었는 지 판별하는 메서드
     */
    private static int getIcebergNums() {
        boolean[][] isChecked = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isChecked[i][j] || iceberg[i][j] < 1) continue;

                dfs(isChecked, i, j);
                count++;
            }
        }

        return count;
    }

    private static void dfs(boolean[][] isChecked, int r, int c) {
        isChecked[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + DIR[d][0];
            int nc = c + DIR[d][1];

            if (!isRange(nr, nc) || isChecked[nr][nc] || iceberg[nr][nc] < 1) continue;

            dfs(isChecked, nr, nc);
        }
    }

    private static int[][] copy(int[][] origin) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                copy[i][j] = origin[i][j];
        }
        return copy;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}
