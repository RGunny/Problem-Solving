package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 그래프, 위상 정렬
 * Gold 2
 * 줄 세우기
 * https://www.acmicpc.net/problem/2252
 */
public class BOJ_2252_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생의 수
        int M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수

        int[] edges = new int[N + 1];

        // 가중치가 없는 그래프(연결 리스트)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        // 단방향 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            edges[v2]++; // 후행 정점에 대한 간선의 수 증가
        }

        // 위상 정렬 : (A, B : A가 B앞에 선다. A가 선행)
        String answer = topologicalSort(graph, edges, N);

        System.out.println(answer);
    }

    private static String topologicalSort(List<List<Integer>> graph, int[] edges, int N) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        // 초기 : 선행 정점을 가지지 않은 정점을 큐에 삽입
        for (int i = 1; i <= N; i++)
            if(edges[i] == 0) q.add(i);

        // 정점의 수 만큼 반복
        for (int i = 0; i < N; i++) {
            // 1. 큐에서 정점 추출
            int v = q.remove();

            sb.append(v + " ");

            // 2. 해당 정점과 연결된 모든 정점에 대해
            for (int nv : graph.get(v)) {
                // 2.1 간선의 수 감소
                edges[nv]--;

                // 2.2 선행 정점을 가지지 않는 정점을 큐에 삽입
                if(edges[nv] == 0) q.add(nv);
            }
        }

        return sb.toString();
    }
}
