package programmers.kakaoblind2020;

/**
 * 2020 KAKAO BLIND RECRUITMENT
 * 자물쇠와 열괴
 * https://programmers.co.kr/learn/courses/30/lessons/60059
 */
public class 자물쇠와열쇠 {
    private static int N, M;

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}; // true
        boolean answer = false;

        M = key.length;
        N = lock.length;
        int offset = M - 1;

        for (int r = 0; r < offset + N; r++) {
            for (int c = 0; c < offset + N; c++) {
                for (int rot = 0; rot < 4; rot++) {
                    int[][] newLock = new int[N + (M - 1) * 2][N + (M - 1) * 2];

                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++)
                            newLock[offset + i][offset + j] = lock[i][j];
                    }

                    rotateAndMatch(newLock, key, rot, r, c);

                    if (isFit(newLock, offset)) {
                        answer = true;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    /**
     * N + (M - 1) * 2 크기로 늘린 newLock 배열에 key를 회전한 값을 더해줌
     * => newLock 배열에 2(기존  lock 값과 key 값이 겹침)가 없고 0이 없이
     * 모두 1로 차게 되면 자물쇠에 키가 일치한 것
     */
    private static void rotateAndMatch(int[][] newLock, int[][] key, int rot, int r, int c) {

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                switch (rot) {
                    case 0: // 0
                        newLock[i + r][j + c] += key[i][j];
                        break;
                    case 1: // 90
                        newLock[i + r][j + c] += key[j][M - 1 - i];
                        break;
                    case 2: // 180
                        newLock[i + r][j + c] += key[M - 1 - i][M - 1 - j];
                        break;
                    case 3:// 270
                        newLock[i + r][j + c] += key[M - 1 - j][i];
                        break;
                }

            }
        }
    }

    private static boolean isFit(int[][] newLock, int offset) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (newLock[offset + i][offset + j] != 1)
                    return false;
            }
        }

        return true;
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

}