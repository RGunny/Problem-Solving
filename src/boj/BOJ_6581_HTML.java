package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문자열, 파싱
 * Silver 1
 * HTML
 * https://www.acmicpc.net/problem/6581
 */
public class BOJ_6581_HTML {
    private static final String hrTag = "--------------------------------------------------------------------------------";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        // 최종 입력은 Ctrl + D입니다.
        StringBuilder sb = new StringBuilder();
        String line = "", sentence = "";
        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);

            while(st.hasMoreTokens()) {
                String word = st.nextToken();

                if(word.equals("<br>")) {
                    sb.append(sentence.trim()).append("\n");
                    sentence = "";
                }
                else if(word.equals("<hr>")) {
                    if(sentence.length() != 0) {
                        sb.append(sentence.trim()).append("\n");
                        sentence = "";
                    }
                    sb.append(hrTag + "\n");
                }
                else {
                    if((sentence + word).length() > 80) {
                        sb.append(sentence.trim()).append("\n");
                        sentence = "";
                    }
                    sentence += word + " ";
                }
            }
        }

        bw.write(sb.toString() + sentence.trim());
        bw.close();
        br.close();
    }

}