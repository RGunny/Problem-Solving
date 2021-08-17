package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 그래프, 위상 정렬
 * Gold 2
 * 줄 세우기
 * https://www.acmicpc.net/problem/2252
 */
public class BOJ_2252_줄세우기_DFS {
    private static Stack<Integer> stack = new Stack<>();
    private static boolean[] visited;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생의 수
        int M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        // 가중치가 없는 그래프(연결 리스트)
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        // 단방향 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop() + " ");

        System.out.print(sb.toString());
    }

    /**
     * Topological Sort (위상 정렬)
     *  : 어떤 일을 하는 순서를 찾는 알고리즘
     *  => 방향 그래프에 존재하는 각 정점들의 선행 순서를 위배하지 않으면서 모든 정점을 나열하는 것
     *  ex) 여러 작업이 있을 때, 특정 작업을 수행하기 전 진행되어야 하는 작업들이 있는데, 이 작업들을 순서에 맞게 정렬해주는 것
     *  => 이 때, 각 작업들은 직전 작업에 의존하게 됨
     *
     *  - DFS로 풀 수 있는 대표적인 정렬 방법
     *  - 의존성 그래프(Dependency Graph)의 모양을 띄어야 함 (각 정점의 의존 관계를 간선으로 나타낸 방향 그래프)
     *  - 사이클이 존재할 수 없음
     *
     *  위상 정렬은 DFS를 종료한 역순의 형태로 나타내어 짐
     */
    private static void dfs(int v) {
        visited[v] = true;

        for (int k : graph[v]) {
            if (visited[k]) continue;

            dfs(k);
        }

        stack.push(v);
    }

}