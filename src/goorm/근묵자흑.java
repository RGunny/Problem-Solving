package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수학
 * Level 2
 * 근묵자흑
 * https://level.goorm.io/exam/47881/%EA%B7%BC%EB%AC%B5%EC%9E%90%ED%9D%91/quiz/1
 */
public class 근묵자흑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        int temp = N - K;

        if(N <= K)
            System.out.println(1);

        else if(temp % (K-1) == 0)
            System.out.println(temp / (K-1) + 1);
        else
            System.out.println(temp / (K-1) + 2);
    }
}
