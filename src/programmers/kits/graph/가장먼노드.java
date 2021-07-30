package programmers.kits.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 그래프
 * Level 3
 * 가장 먼 노드
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 */
public class 가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        int answer = bfs(n, edge);

        System.out.println("answer = " + answer);

    }

    private static int bfs(int n, int[][] edge) {

        boolean[] visited = new boolean[n + 1];
        boolean[][] contacts = new boolean[n + 1][n + 1];

        // 단반향 그래프이므로 양쪽 모두 연결 상태로 초기화
        for (int i = 0; i < edge.length; i++) {
            contacts[edge[i][0]][edge[i][1]] = true;
            contacts[edge[i][1]][edge[i][0]] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1); // 1에서 가장 떨어진 노드를 찾으므로 1로 초기화
        visited[1] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int node = q.poll();
                for (int j = 1; j <= n; j++) {
                    if (contacts[j][node] && !visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
            count = qSize;
        }

        return count;
    }

}
