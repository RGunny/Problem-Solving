package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 수학
 * Level 3
 * 문제 선정하기
 * https://devth-preview.goorm.io/exam/53763/%EC%A3%BC-%EA%B5%AC%EB%A5%B4%EB%AF%B8-%EC%8B%A0%EC%9E%85-%EA%B0%9C%EB%B0%9C%EC%9E%90-%EA%B3%B5%EA%B0%9C%EC%B1%84%EC%9A%A9-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8/quiz/1
 */
public class 문제선정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        boolean isFlag = false;
        if (set.size() >= 3) {

            int cur = set.pollFirst();
            int cnt = 1;
            for (int value : set) {
                if (cur >= value) {
                    break;
                } else {
                    cur = value;
                    cnt++;
                }
                if (cnt >= 3) {
                    isFlag = true;
                    break;
                }
            }
        }

        if (isFlag) System.out.println("YES");
        else System.out.println("NO");

    }
}