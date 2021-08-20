package programmers.kakaointern2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 2020 카카오 인턴십
 * 보석 쇼핑
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 */
public class 보석쇼핑 {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
//        String[] gems = {"XYZ", "XYZ", "XYZ"};
//        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();

        int N = gems.length;
        int typesOfJem = set.size();

        int r = 0, m = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {

            while (r < N && map.size() != typesOfJem) {

                map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
                r++;
            }

            if (map.size() == typesOfJem && m > r - i) {

                m = r - i; // 최대 길이
                answer[0] = i + 1; // m
                answer[1] = r; // m
            }

            // 최대 길이가 현재 거리보다 작고, 총 갯수가 같으면
            map.put(gems[i], map.getOrDefault(gems[i], 0) - 1);
//            map.put(gems[i], map.get(gems[i]) - 1);

            if (map.get(gems[i]) == 0)
                map.remove(gems[i]);

        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
