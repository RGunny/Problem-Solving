package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열, 스택
 * Gold 4
 * 문자열 폭발
 * https://www.acmicpc.net/problem/9935
 */
public class 문자열폭발_V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String bomb = br.readLine();

        String ans = explosion(input, bomb);
        System.out.println(ans.length() == 0 ? "FRULA" : ans);
    }

    private static String explosion(String input, String bomb) {
        char[] result = new char[input.length()];
        int index = 0;

        for (int i = 0; i < input.length(); i++) {
            result[index] = input.charAt(i);

            if (isBomb(result, index, bomb)) {
                index -= bomb.length();
            }

            index += 1;
        }

        return String.valueOf(result, 0, index);
    }

    private static boolean isBomb(char[] result, int index, String bomb) {
        if (index < bomb.length() - 1) {
            return false;
        }

        for (int i = 0; i < bomb.length(); i++) {
            if (bomb.charAt(i) != result[index - bomb.length() + 1 + i]) {
                return false;
            }
        }

        return true;
    }
}