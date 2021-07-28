package programmers.kits.dfsbfs;

/**
 * 깊이/너비 우선 탐색(DFS/BFS)
 * Level 3
 * 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
public class 네트워크 {
    public static void main(String[] args) {
        int n = 6;
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; // return 2
//        int[][] computers = {{1, 1, 0}, {1, 1, 1},{0, 1, 1}}; // return 1
//        int[][] computers = {{1, 0, 0, 0, 0}, {0, 1, 1, 1, 1}, {0, 1, 1, 1, 1}, {0, 1, 1, 1, 1}, {0, 1, 1, 1, 1}};
        int[][] computers = {{1, 0, 0, 0, 0, 1}, {0, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 0}, {0, 1, 1, 0, 1, 0}, {1, 0, 0, 0, 0, 1}}; // return 2

        boolean[] checked = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                dfs(n, computers, i, checked);
                count += 1;
            }
        }

        System.out.println("count = " + count);
    }

    private static boolean[] dfs(int n, int[][] computers, int depth, boolean[] checked) {

        checked[depth] = true;

        for (int i = 0; i < n; i++) {
            if (!checked[i] && depth != i && computers[depth][i] == 1)
                checked = dfs(n, computers, i, checked);
        }

        return checked;
    }

}
