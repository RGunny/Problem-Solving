package programmers.kits.dp;

/**
 * 동적 프로그래밍
 * Level 3
 * N으로 표현
 * https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
 */
public class N으로표현_DFS {
    private static int N;
    private static int number;
    private static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        N = 5;
        number = 31168;

        if (number == N)
            minCnt = 1;
        else
            dfs(0, 0);

        minCnt = minCnt == Integer.MAX_VALUE ? -1 : minCnt;

        System.out.println("minCnt = " + minCnt);
    }

    private static void dfs(int val, int cnt) {

        if (cnt > 8) {
            minCnt = -1;
            return;
        }

        if (val == number) {
            minCnt = minCnt > cnt ? cnt : minCnt;
            return;
        }

        int curN = N;
        for (int i = 0; i < 8 - cnt; i++) {
            dfs(val + curN, cnt + 1 + i); // + 연산
            dfs(val - curN, cnt + 1 + i); // - 연산
            dfs(val * curN, cnt + 1 + i); // * 연산
            dfs(val / curN, cnt + 1 + i); // / 연산 (나머지 무시)

            curN = curN * 10 + N; // NN 연속된 수 연산
        }
    }
}
