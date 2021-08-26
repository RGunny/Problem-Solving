package programmers.weeklychellenge;

import java.util.*;

/**
 * 프로그래머스 위클리 챌린지 - 4주차
 * 직업군 추천하기
 * https://programmers.co.kr/learn/courses/30/lessons/84325
 */
public class 직업군추천하기 {
    public static void main(String[] args) {
//        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
//        String[] languages = {"PYTHON", "C++", "SQL"};
//        int[] preference = {7, 5, 5}; // "HARDWARE"
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"JAVA", "JAVASCRIPT"};
        int[] preference = {7, 5}; // "PORTAL"

        int lanLen = languages.length;
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < 5; i++) {

            String[] spilted = table[i].split(" ");
            int length = spilted.length;
            int score = 0;

            for (int j = 1; j < length; j++) {
                for (int k = 0; k < lanLen; k++) {
                    if (spilted[j].equals(languages[k]))
                        score += preference[k] * (length - j);
                }

            }
            map.put(spilted[0], score);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
