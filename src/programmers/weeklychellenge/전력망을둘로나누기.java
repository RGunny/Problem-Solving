package programmers.weeklychellenge;

/**
 * 프로그래머스 위클리 챌린지 - 9주차
 * 전력망을 둘로 나누기
 * https://programmers.co.kr/learn/courses/30/lessons/86971
 */
public class 전력망을둘로나누기 {
    private static int[] parents;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}; // 3

        int answer = Integer.MAX_VALUE;
        parents = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {

            make(n);
            for (int j = 0; j < n - 1; j++) {
                if (i == j) continue;

                int a = wires[j][0];
                int b = wires[j][1];

                union(a, b);
            }
            answer = Math.min(answer, calc(n));
        }

        System.out.println(answer);
    }

    private static int calc(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (find(parents[i]) == 1) count++;
        }

        return Math.abs(n - 2 * count);
    }

    private static void make(int n) {
        for (int i = 1; i <= n; i++) {
            parents[i] = i; // 부모를 자신의 index로 표기
        }
    }

    // 일반멤버 a를 포함하는 집합의 대표자 index를 리턴
    private static int find(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]); // Path Compression(경로 압축)
    }

    // 일반 멤버a, 일반 멤버 b를 포함하는 두 집합을 통합
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot > bRoot) {
            int temp = aRoot;
            aRoot = bRoot;
            bRoot = temp;
        }

        // 다른 집합일 때만 합치기, 같은 집합인데 합치면 StackOverflowError
        if (aRoot != bRoot)
            parents[bRoot] = aRoot;
    }
}
