package programmers.kakaoblind2018;

import java.util.LinkedList;
import java.util.Locale;

/**
 * 2018 KAKAO BLIND RECRUITMENT
 * 캐시
 * https://programmers.co.kr/learn/courses/30/lessons/17680?language=java
 */
public class 캐시 {
    private static final int CACHE_HIT = 1, CACHE_MISS = 5;

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}; // 50

//        Arrays.stream(cities).forEach(city -> city.toLowerCase(Locale.ROOT));

        int time = 0;

        // 모든 경우 CACHE_MISS 발생
        time = (cacheSize == 0) ? 5 * cities.length : LRUCahe(time, cacheSize, cities);

        System.out.println(time);
    }

    private static int LRUCahe(int time, int cacheSize, String[] cities) {

        LinkedList<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase(Locale.getDefault());

            // cache hit => time + 1
            if (cache.remove(city)) {
                cache.addFirst(city);
                time += CACHE_HIT;
            }
            // cache miss => time + 5
            else {
                int size = cache.size();

                if (size == cacheSize) cache.pollLast();
                cache.addFirst(city);
                time += CACHE_MISS;
            }
        }
        return time;
    }
}