package programmers.kits.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 힙
 * Level 3
 * 이중우선순위큐
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I 16","D 1"};
//        String[] operations = {"I 7","I 5","I -5","D -1"};

        int[] answer = calcDualPq(operations);

    }

    private static int[] calcDualPq(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = new int[2];

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation, " ");
            String order = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            // 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
            if (pq.size() < 1 && order.equals("D")) continue;

            if (order.equals("I")) {
                pq.add(value);
                pqDesc.add(value);
            }

            else if (value == 1) {
                int max = pqDesc.poll();
                pq.remove(max);
            }

            else if (value == -1){
                int min = pq.poll();
                pqDesc.remove(min);
            }
        }

        if(pq.size() > 0 ) {
            answer[0] = pqDesc.poll();
            answer[1] = pq.poll();
        }

        return answer;

    }
}
