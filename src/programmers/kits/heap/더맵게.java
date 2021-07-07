package programmers.kits.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 힙
 * Level 2
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
 */
public class 더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        q(scoville, K);
        pq(scoville, K);


    }

    private static void pq(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int k : scoville) {
            pq.add(k);
        }
        int cnt = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            pq.add(pq.remove() + (pq.remove() * 2));
            cnt += 1;
        }

        System.out.println("cnt = " + cnt);

    }

    private static void q(int[] scoville, int K) {
        Queue<Integer> q = new LinkedList<>();

        int len = scoville.length;
        for (int i = 0; i < len; i++) {
            q.add(scoville[i]);
        }

        int nk = 0;
        int cnt = 0;
        while (q.peek() < K) {
            if(q.size() > 2) System.out.println(-1);
            q.stream().sorted();
            int f1 = q.poll();
            int f2 = q.poll();

            nk = f1 + (f2 * 2);
            q.add(nk);
            cnt += 1;
        }

        System.out.println("cnt = " + cnt);
    }
}
