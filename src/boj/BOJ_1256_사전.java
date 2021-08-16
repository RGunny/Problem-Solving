package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문자열, DP, 조합, 수학
 * Gold 3
 * 사전
 * https://www.acmicpc.net/problem/1256
 */
public class BOJ_1256_사전 {
    private static int N, M, K, num = 0, count = 0;
    private static char result[];
    private static boolean check[][];
    private static long cnt[][];
    private static long mod = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cnt = new long[200 + 1][100 + 1];
        check = new boolean[200 + 1][100 + 1];
        result = new char[N + M + 1];

        long num = binary(N + M, M);
        if (num >= K) {
            Arrays.fill(result, 'a');
            find(N + M, M, K);
            for (int i = 0; i < N + M; i++) sb.append(result[i]);
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    private static long binary(int n, int m) {
        if (n < m) return 0;
        if (n == m || m == 0) return 1;
        if (check[n][m]) return cnt[n][m];
        check[n][m] = true;
        cnt[n][m] += binary(n - 1, m);
        cnt[n][m] += binary(n - 1, m - 1);
        return Math.min(cnt[n][m], 1000000001);
    }

    private static void find(int n, int m, long k) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++)
                result[num + i] = 'a';
            return;
        }
        long pivot = binary(n - 1, m);
        if (pivot < k) {
            result[num++] = 'z';
            find(n - 1, m - 1, k - pivot);
        } else {
            result[num++] = 'a';
            find(n - 1, m, k);
        }
    }
}
