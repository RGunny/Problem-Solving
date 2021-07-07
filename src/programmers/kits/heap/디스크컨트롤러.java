package programmers.kits.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 힙
 * Level 3
 * 디스크 컨트롤러
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class 디스크컨트롤러 {
    private static int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

    public static void main(String[] args) {

        // 1. 요청 시간 기준 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int minAvg = getMinAvg(jobs.length, 0, 0, 0, 0);

        System.out.println("minAvg = " + minAvg);
    }

    // 작업 갯수, 현재 수행된 요청 갯수, jobs 인덱스, 현재 작업이 끝난 시간, 대기 시간을 포함한 전체 작업 수행 시간
    private static int getMinAvg(int length, int count, int index, int end, int sum) {
        // 2. 처리 시간 기준 오름차순 정렬 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 3. 모든 요청이 수행될 때까지 반복
        while (count < length) {

            // 3.1 현재 작업이 완료되기 전까지 들어온 모든 요청을 큐에 삽입
            // => 대기 시간을 고려한 다음 작업 우선순위를 정하기 위함
            while (index < length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }

            // 3.2.1 현재 큐가 비어 있다면, 현재 작업 종료 시간과 새로운 요청 시작 시간 사이에 텀이 있음
            if (pq.isEmpty()) {
                end = jobs[index][0]; // 작업이 끝난 시간을 다음 처리 시간을 나타내는 인덱스의 요청 시작시점으로 바꿈
            }
            // 3.2.2 큐에 담긴 요청 중(3.1에서 들어온 요청) (대기 시간 + 수행 시간)이 가장 짧은 요청부터 수행
            else {
                int[] temp = pq.poll();
                sum += temp[1] + (end - temp[0]); // 수행 시간 + (요청부터 작업 시작까지 대기 시간)
                end += temp[1];
                count += 1;
            }
        }

        return (int) Math.floor(sum / length);
    }

}
