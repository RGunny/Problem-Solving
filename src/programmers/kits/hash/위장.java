package programmers.kits.hash;

import java.util.HashMap;

/**
 * 해시
 * Level 2
 * 위장
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 */
public class 위장 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        HashMap<String, Integer> map = initMap(clothes);
        int num = getNum(map);

        System.out.println("num = " + num);
    }

    private static HashMap<String, Integer> initMap(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();
        int len = clothes.length;
        for (int i = 0; i < len; i++) {
            // map에 해당 키값이 있다면,
            if (map.containsKey(clothes[i][1])) {
                // 해당 키의 value + 1
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                // 해당 키값으로 value 1 초기화
                map.put(clothes[i][1], 1);
            }
        }

        return map;
    }

    private static int getNum(HashMap<String, Integer> map) {

        int num = 1;
        for (Integer value : map.values()) {
            num *= value + 1;
        }

        return num - 1;
    }
}
