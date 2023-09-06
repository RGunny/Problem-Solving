package programmers.kakaointern2022;

import java.util.*;

public class 성격유형검사하기 {

    public static void main(String[] args) {
        solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}); // TCMA
        solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}); // RCJA
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        // 각 유형별 누적점수를 담을 map
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            String negative = survey[i].substring(0, 1);
            String positive = survey[i].substring(1, 2);

            if (choices[i] < 4)
                map.put(negative, map.getOrDefault(negative, 0) + (4 - choices[i]));
            else
                map.put(positive, map.getOrDefault(positive, 0) + (choices[i] - 4));

        }
        // RT CF JM AN
        if (map.getOrDefault("R", 0) >= map.getOrDefault("T", 0))
            answer += "R";
        else
            answer += "T";
        if (map.getOrDefault("C", 0) >= map.getOrDefault("F", 0))
            answer += "C";
        else
            answer += "F";
        if (map.getOrDefault("J", 0) >= map.getOrDefault("M", 0))
            answer += "J";
        else
            answer += "M";
        if (map.getOrDefault("A", 0) >= map.getOrDefault("N", 0))
            answer += "A";
        else
            answer += "N";

        return answer;
    }
}
