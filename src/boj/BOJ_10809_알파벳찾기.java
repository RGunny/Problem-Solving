package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * 문자열
 * Bronze 2
 * 알파벳 찾기
 * https://www.acmicpc.net/problem/10809
 */
public class BOJ_10809_알파벳찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine().toLowerCase(Locale.ROOT);
//        "abcdefghrcklmnopqrstuvwxyz";

        for (char i = 'a'; i <= 'z'; i++) {
            if (input.contains(String.valueOf(i))) {
                sb.append(input.indexOf(i));
            } else {
                sb.append("-1");
            }
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}
