package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬, 문자열, 구현
 * Bronze 1
 * 팰린드롬 수
 * https://www.acmicpc.net/problem/1259
 */
public class BOJ_1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.equals("0")) break;

            if (isPalindrome(input)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean isPalindrome(String s) {

        int start = -1, end = s.length();
        while (start++ < end--) {

            if(s.charAt(start) != s.charAt(end)) return false;
        }

        return true;
    }
}
