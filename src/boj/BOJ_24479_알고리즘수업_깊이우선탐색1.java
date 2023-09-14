package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * DFS
 * Silver 2
 * 알고리즘 수업 - 깊이 우선 탐색 1
 * https://www.acmicpc.net/problem/24479
 */
public class BOJ_24479_알고리즘수업_깊이우선탐색1 {
    static final int MAX = 100000 + 10;
    static int N, M, R, order;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[MAX];
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;


        // 1. graph 에 연결 정보 채우기
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 2. 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 3. dfs
        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int depth) {
        visited[depth] = true;
        answer[depth] = order++;

        for (int i = 0; i < graph[depth].size(); i++) {
            if(visited[graph[depth].get(i)]) continue;
            dfs(graph[depth].get(i));
        }
    }

}
