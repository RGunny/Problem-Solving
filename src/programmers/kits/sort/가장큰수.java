package programmers.kits.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 정렬
 * Level 2
 * 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
 */
public class 가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};

        // 문자열을 return할 배열 생성
        String[] str = new String[numbers.length];

        int len = str.length;
        // 1. int to String
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 2. Desc Sort
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // 3. Get Answer
        String ans = "";
        if (str[0].equals("0")) { // 내림차순 정렬을 했으므로, 0번째 인덱스가 "0"일 시, 모두 0
            ans += "0";
        } else {
            for (int i = 0; i < len; i++) {
                ans += str[i];
            }
        }

        System.out.println("ans = " + ans);
    }

}
