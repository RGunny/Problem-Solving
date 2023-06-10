package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Graph(Union-Find)
 * Gold 4
 * 거짓말
 * https://www.acmicpc.net/problem/1043
 */
public class BOJ_1043_거짓말 {
    private static int N, M, total = 0;
    private static int[] parents;
    private static boolean[] truePeople = new boolean[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // the number of people
        M = Integer.parseInt(st.nextToken()); // the number of parties

        // 1. union-find init
        parents = new int[N + 1];
        make();

        // 2. 진실을 아는 사람 정보 받아오기 truePeople[진실을아는사람] == true
        st = new StringTokenizer(br.readLine());
        int knowTruthNums = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowTruthNums; i++)
            truePeople[Integer.parseInt(st.nextToken())] = true;

        // 3. 파티 정보를 받아오면서 같은 파티에 있는 사람들 union
        List<Integer>[] people = new ArrayList[M];
        for (int i = 0; i < M; i++)
            people[i] = new ArrayList<>();

        int value, pre = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int nums = Integer.parseInt(st.nextToken());
            if (nums > 0) {
                pre = Integer.parseInt(st.nextToken());
                people[i].add(pre);
            }
            for (int j = 1; j < nums; j++) {
                value = Integer.parseInt(st.nextToken());
                people[i].add(value);
                union(pre, value); // 두명씩 union하면 모두가 같은 parent를 갖게 됨.
                pre = value;
            }
        }

        // 4. 진실을 아는 사람들의 parent는 같이 파티를 참여 했으므로 진실을 아는 사람들
        for (int i = 1; i < truePeople.length; i++) {
            if (truePeople[i])
                truePeople[find(i)] = true;
        }

        // 5. 진실을 아는 사람들과 파티를 같이 하지 않았으면 total++
        int parent = 0;
        for (int i = 0; i < M; i++) {
            if (people[i].size() > 0) {
                parent = find(people[i].get(0));
                if (!truePeople[parent]) total++;
            }
        }

        // 6. 거짓말 할 수 있는 파티 최대 수 출력
        System.out.println(total);
    }

    /**
     * 유일한 멤버 x를 포함하는 새로운 집합을 생성하는 연산
     */
    public static void make() {
        for (int i = 1; i <= N; i++)
            parents[i] = i; // Mark the parent as its index
    }

    /**
     * x를 포함하는 집합(대표자)을 찾는 연산, 대표자 idx 리턴
     */
    private static int find(int x) {
        if (parents[x] == x)
            return parents[x] = x; // if x is not root
        else {
            parents[x] = find(parents[x]);// Path Compression
            return parents[x];
        }
    }

    /**
     * x와 y를 포함하는 두 집합을 통합하는 연산
     */
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) // union only when different sets, If union when same set, occur StackOverflowError
            parents[y] = x;

    }
}
