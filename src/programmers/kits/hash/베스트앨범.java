package programmers.kits.hash;

import java.util.*;

/**
 * 해시
 * Level 3
 * 베스트앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 */
public class 베스트앨범 {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};


        int len = plays.length;

        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, int[]> map = new HashMap<>();

        // 장르에 대해 전체 재생횟수 저장
        for (int i = 0; i < len; i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> genreOrder = new ArrayList<>(hm.entrySet());
        Collections.sort(genreOrder, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        List<Integer> ans = new ArrayList<>();
        int genreLen = genreOrder.size();


    }
}
