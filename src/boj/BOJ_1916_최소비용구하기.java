package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 다익스트라 알고리즘
 * Gold 5
 * 최소비용 구하기
 * https://www.acmicpc.net/problem/1916
 */
public class BOJ_1916_최소비용구하기 {
    private static int N, M, s, e;
    private static List<City>[] cities;
    private static int[] dists;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        cities = new ArrayList[N + 1];
        dists = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        Arrays.fill(dists, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            cities[start].add(new City(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int answer = dijkstra();
        System.out.println(answer);
    }

    private static int dijkstra() {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(s, 0));
        dists[s] = 0;

        while (!pq.isEmpty()) {
            City cur = pq.poll();

            if(visited[cur.vertex]) continue;

            visited[cur.vertex] = true;

            for (City city : cities[cur.vertex]) {
                if(visited[city.vertex]) continue;
                if(dists[cur.vertex] + city.weight >= dists[city.vertex]) continue;

                dists[city.vertex] = dists[cur.vertex] + city.weight;
                pq.add(new City(city.vertex, dists[city.vertex]));
            }
        }
        return dists[e];
    }

    private static class City implements Comparable<City> {
        int vertex, weight;

        public City(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(City c) {
            return Integer.compare(this.weight, c.weight); // ASC
        }
    }
}
