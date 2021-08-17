package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 그리디, 정렬
 * Platinum 5
 * 숫자의 신
 * https://www.acmicpc.net/problem/1422
 */
public class BOJ_1422_숫자의신 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // K개의 자연수
        int N = Integer.parseInt(st.nextToken()); // N개를 뽑음
        int maxNum = -1;

        String[] numbers = new String[K];
        for (int i = 0; i < K; i++) {
            numbers[i] = br.readLine();
            maxNum = Math.max(maxNum, Integer.parseInt(numbers[i]));
        }

        Arrays.sort(numbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        String answer = getMaxNum(N, K, maxNum, numbers);

        System.out.println(answer);
    }

    private static String getMaxNum(int N, int K, int maxNum, String[] numbers) {

        StringBuilder sb = new StringBuilder();
        boolean isUsed = false;

        for (int i = 0; i < K; i++) {
            sb.append(numbers[i]);

            if (!isUsed && maxNum == Integer.parseInt(numbers[i])) {
                isUsed = true;
                for (int j = 0; j < (N - K); j++)
                    sb.append(numbers[i]);
            }
        }

        return sb.toString();
    }
}
