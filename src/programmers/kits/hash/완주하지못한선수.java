package programmers.kits.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 해시
 * Level 1
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 */
public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(getPersonBySort(participant, completion));
        System.out.println(getPersionByHashMap(participant, completion));
    }

    /**
     * HashMap을 이용한 풀이
     */
    private static String getPersionByHashMap(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 1. Put the participant array to the hashmap while increasing the value.
        for (String person : participant) {
            hashMap.put(person, hashMap.getOrDefault(person, 0) + 1);
        }

        // 2. Put the participant array into the hashmap while reducing the value.
        for (String person : completion) {
            hashMap.put(person, hashMap.get(person) - 1);
        }

        // 3. Find a key whose value is not 0.
        String ans = "";
        for (Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 0) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }

    /**
     * 정렬을 이용한 문자열 비교 풀이
     */
    private static String getPersonBySort(String[] participant, String[] completion) {
        // 1. Sort the array in ascending order.
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. Compare strings in two sorted arrays.
        int len = completion.length;
        for (int i = 0; i < len; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        // 3. If at the end
        return participant[len];
    }
}
