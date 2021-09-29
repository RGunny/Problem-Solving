package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수학
 * Level 3
 * 사은품 교환하기
 * https://level.goorm.io/exam/47878/%EC%82%AC%EC%9D%80%ED%92%88-%EA%B5%90%ED%99%98%ED%95%98%EA%B8%B0/quiz/1
 */
public class 사은품교환하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken()); // 시즌한정
            long M = Long.parseLong(st.nextToken()); // 일반

            long answer = getNum(N, M);
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }

    private static long getNum(long N, long M) {
        return Math.min((N + M) / 12, N / 5);
    }
}
