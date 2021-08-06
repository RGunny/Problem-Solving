package programmers.kits.dp;

import java.util.Arrays;

/**
 * 동적 프로그래밍
 * Level 3
 * 등굣길
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */
public class 등굣길_Recursion {
    private static int[][] map;
    private static int row, col;

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        row = n;
        col = m;

        map = new int[n + 1][m + 1];
        Arrays.stream(puddles).forEach(puddle -> map[puddle[1]][puddle[0]] = -1);
        map[n][m] = 1;

        System.out.println(recursion(1, 1));
    }

    private static int recursion(int r, int c) {
        if (r > row || c > col || map[r][c] < 0) return 0;
        if (map[r][c] > 0) return map[r][c];
        return map[r][c] = (recursion(r, c + 1) + recursion(r + 1, c)) % 1000000007;
    }

}
