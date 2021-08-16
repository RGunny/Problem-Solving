package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1256_사전_V2 {
    private static long[][] dp;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N, M, K;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[N + 1][M + 1];


        if (K > numWord(N, M)) {
            System.out.println("-1");
        } else {
            getWord(N, M, K - 1);
        }
        bw.write("\n");
        bw.close();
    }

    private static long numWord(int N, int M) {
        if (N == 0 || M == 0)
            return 1;
        if (dp[N][M] != 0)
            return dp[N][M];
        return dp[N][M] = Long.min(numWord(N - 1, M) + numWord(N, M - 1), 1000000001);
    }

    private static void getWord(int N, int M, long before) throws IOException {
        if (N == 0) {
            for (int i = 0; i < M; i++)
                bw.write("z");
            return;
        }
        if (M == 0) {
            for (int i = 0; i < N; i++)
                bw.write("a");
            return;

        }
        long tmp = numWord(N - 1, M);

        if (before < tmp) {
            bw.write("a");
            getWord(N - 1, M, before);
        } else {
            bw.write("z");
            getWord(N, M - 1, before - tmp);
        }
    }
}