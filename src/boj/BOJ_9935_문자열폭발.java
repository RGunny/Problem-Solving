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
public class BOJ_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 주어진 문자열
        String bombStr = br.readLine(); // 폭발 문자열
        int bombLen = bombStr.length();

        StringBuilder sb = new StringBuilder();
        int sbSize = 0;

        for (int i = 0; i < str.length(); i++) {
            if (sbSize - bombLen < 0) {
                sb.append(str.substring(i, i + 1));
                sbSize += 1;
                continue;
            }

            if (sb.substring(sbSize - bombLen, sbSize).equals(bombStr)) {
                sb.delete(sbSize - bombLen, sbSize);
                sbSize -= bombLen;
            }

            sb.append(str.substring(i, i + 1));
            sbSize += 1;
        }

        if (sb.substring(sbSize - bombLen, sbSize).equals(bombStr)) {
            sb.delete(sbSize - bombLen, sbSize);
        }

        if (sb.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(sb.toString());

    }
}
