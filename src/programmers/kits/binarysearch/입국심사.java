package programmers.kits.binarysearch;

import java.util.Arrays;

/**
 * 이분 탐색(Binary Search)
 * Level 3
 * 입국심사
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 */
public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        long minTime = binarySearch(n, times);

        System.out.println(minTime);
    }

    private static long binarySearch(int n, int[] times) {
        // 이분 탐색 구현
        long minTime = 0;
        // 1. 정렬
        Arrays.sort(times);

        // 2. 이분 탐색을 위한 포인터 설정
        int timesLen = times.length;
        long start = 1; // 최선의 경우
        long end = (long) n * times[timesLen - 1]; // 최악의 경우 (가장 오래 걸리는 시간)

        // 3. 이분 탐색 시작
        // 찾아야 하는 target은 사람의 수
        // 사람의 수 = 주어진 시간 / 해결 시간
        while (start <= end) {
            // 3.1 배열의 중앙에 있는 값을 조사하여 찾고자 하는 항목이 왼쪽 또는 오른쪽 배열에 있는 지를
            // 알아내어 탐색의 범위를 반으로 줄임
            long mid = (start + end) / 2;
            long sum = 0; // 총 심사한 인원

            // 3.2 심사관마다 mid 시간을 기준으로 심사할 수 있는 사람 수의 합
            for (int i = 0; i < timesLen; i++)
                sum += mid / times[i];

            // 3.3.1 심사하는 사람의 수가 더 적음 => 시간 더 필요함
            if(sum < n)
                start = mid + 1;

            // 3.3.2 심사하는 사람의 수가 많거나 같음 => 시간을 줄일 수 있음
            else {
                end = mid - 1;
                minTime = mid;
            }
        }

        return minTime;
    }
}
