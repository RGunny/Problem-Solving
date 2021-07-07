package programmers.dev_matching_back_2021;

/**
 * 2021 Dev-Matching: 웹 백앤드 개발
 * 행렬 테두리 회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 */
public class 행렬테두리회전하기 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        int[] ans = new int[queries.length];
        int[][] map = createMap(rows, columns);
        int qLen = queries.length;
        for (int i = 0; i < qLen; i++) {
            ans[i] = rotate(map, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
            System.out.print(ans[i] + " ");
        }


    }


    private static int rotate(int[][] map, int x1, int y1, int x2, int y2) {

        int temp = map[x1][y1];
        int min = temp;

        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(min, map[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }

        for (int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(min, map[x1][i]);
        }
        map[x1][y1 + 1] = temp;

        return min;
    }

    private static int[][] createMap(int r, int c) {
        int[][] map = new int[r+1][c+1];
        int cnt = 1;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                map[i][j] = cnt++;
            }
        }
        return map;
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] >= 10)
                    System.out.print(map[i][j] + " ");
                else
                    System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
