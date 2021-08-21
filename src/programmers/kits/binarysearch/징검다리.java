package programmers.kits.binarysearch;

import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2; // 4

        int answer = binarySearch(distance, rocks, n);

        System.out.println(answer);
    }

    private static int binarySearch(int distance, int[] rocks, int n) {
        int answer = 0;
        // 1. 정렬
        Arrays.sort(rocks);

        int length = rocks.length;
        int start = 1;
        int end = distance;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            int prev = 0;

            for (int i = 0; i < length; i++) {
                // 현재 바위 - 이전바위 < mid
                if (rocks[i] - prev < mid)
                    count++; // 바위를 지움
                else
                    prev = rocks[i]; // 이전 바위 위치를 현재 바위 위치로 최신화
            }

            // 마지막 돌과 도착점 사이의 거리 확인
            if(distance - prev < mid)
                count++;

            if (count <= n) {
                // 최솟값들 중 최댓값 구하기
                answer = answer > mid ? answer : mid;
                start = mid + 1;
            }
            // 지운 바위 개수가 n보다 크다면
            else
                end = mid - 1;
        }
        return answer;
    }
}
