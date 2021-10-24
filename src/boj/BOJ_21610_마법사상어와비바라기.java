package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 구현, 시뮬레이션
 * Gold 5
 * 마법사 상어와 비바라기
 * https://www.acmicpc.net/problem/21610
 */
public class BOJ_21610_마법사상어와비바라기 {
    // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    private static int[][] dir = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    private static int N, M;
    private static int[][] map, orders;
    private static List<Cloud> clouds = new LinkedList<>();
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        orders = new int[M][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            orders[i][0] = Integer.parseInt(st.nextToken());
            orders[i][1] = Integer.parseInt(st.nextToken());
        }

        go();

    }

    private static void go() {

//        (N, 1), (N, 2), (N-1, 1), (N-1, 2)
        clouds.add(new Cloud(N, 1));
        clouds.add(new Cloud(N, 2));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 1, 2));

        for (int i = 0; i < M; i++) {

            visited = new boolean[N + 1][N + 1];
            moveAndRain(orders[i][0], orders[i][1]);
            waterCopyMagic();
            remove();

        }
        System.out.println(count());
    }

    private static int count() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                count += map[i][j];
            }
        }
        return count;
    }

    private static void remove() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (visited[i][j] || map[i][j] < 2) continue;

                map[i][j] -= 2;
                clouds.add(new Cloud(i, j));
            }
        }
    }

    private static void waterCopyMagic() {
        for (Cloud cloud : clouds) {
            int count = 0;
            for (int i = 2; i <= 8; i += 2) {
                int nr = cloud.r + dir[i][0];
                int nc = cloud.c + dir[i][1];

                if (!isRange(nr, nc)) continue;
                if (map[nr][nc] < 1) continue;

                count++;
            }
            map[cloud.r][cloud.c] += count;
        }
        clouds.clear();
    }

    private static void moveAndRain(int d, int s) {
        for (Cloud cloud : clouds) {

            int nr = getNext(cloud.r, dir[d][0] * s % N);
            int nc = getNext(cloud.c, dir[d][1] * s % N);

            visited[nr][nc] = true;
            map[nr][nc] += 1;
            cloud.r = nr;
            cloud.c = nc;
        }
    }

    private static int getNext(int prev, int weight) {
        int next = (prev + weight + N) % N;

        return next > 0 ? next : N;
    }

    private static boolean isRange(int nr, int nc) {
        return nr > 0 && nr <= N && nc > 0 && nc <= N;
    }

    private static class Cloud {
        int r, c;

        public Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
