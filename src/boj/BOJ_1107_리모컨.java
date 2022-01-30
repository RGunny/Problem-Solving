package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Brute Force
 * Gold 5
 * 리모컨
 * https://www.acmicpc.net/problem/1107
 */
public class BOJ_1107_리모컨 {
    private static final int MAX_NUMBER = 999999;
    private static int target, M;
    private static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        target = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                broken[Integer.parseInt(st.nextToken())] = true;
        }

        int answer = solve();
        System.out.println(answer);
    }

    private static int solve() {
        // +, - 로만 누르는 경우 (최초 채널은 100) (모든 리모컨 버튼이 고장났을 경우)
        int minNum = Math.abs(target - 100);

        for (int i = 0; i <= MAX_NUMBER; i++) {
            String str = String.valueOf(i);
            int length = str.length();

            boolean isBroken = false;
            for (int j = 0; j < length; j++) {
                // 고장난 버튼을 눌러야 하면
                if (broken[str.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }
            // 고장나지 않은 버튼으로 목표와 가장 근사한 값을 생성
            if (!isBroken) {
                int min = length + Math.abs(target - i); // i(length)로 이동 후  target까지 이동하는 횟수 (+, -)
                minNum = Math.min(min, minNum);
            }
        }
        return minNum;
    }

}
