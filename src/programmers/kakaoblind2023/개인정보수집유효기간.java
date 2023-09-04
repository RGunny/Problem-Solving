package programmers.kakaoblind2023;

import java.util.*;

public class 개인정보수집유효기간 {

    public static void main(String[] args) {

        solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth = Integer.parseInt(today.substring(5, 7));
        int todayDay = Integer.parseInt(today.substring(8, 10));


        // 1. terms 를 {약관종류 : 유효기간}으로 map 에 초기화
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] splited = term.split(" ");
            termsMap.put(splited[0], Integer.parseInt(splited[1]) * 28);
        }

        // 2, privacies 를 순회하며 판별
        for (int i = 0; i < privacies.length; i++) {
            String[] splited = privacies[i].split(" ");
            String startedDate = splited[0];
            String type = splited[1];

            int term = termsMap.get(type);
            int year = Integer.parseInt(startedDate.substring(0, 4));
            int month = Integer.parseInt(startedDate.substring(5, 7));
            int day = Integer.parseInt(startedDate.substring(8, 10));

            int total = (todayYear - year) * 12 * 28 +  (todayMonth - month) * 28 + todayDay - day;

            if(total >= term) answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
