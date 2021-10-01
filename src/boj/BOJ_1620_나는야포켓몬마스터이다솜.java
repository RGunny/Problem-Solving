package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 해시, 맵
 * Silver 4
 * 나는야 포켓몬 마스터 이다솜
 * https://www.acmicpc.net/problem/1620
 */
public class BOJ_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            String index = String.valueOf(i);
            map.put(s, index);
            map.put(index, s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        
        System.out.println(sb.toString());
    }
}
