package programmers.weeklychellenge;

import java.util.*;

/**
 * 프로그래머스 위클리 챌린지 - 7주차
 * 입실 퇴실
 * https://programmers.co.kr/learn/courses/30/lessons/86048
 */
public class 입실퇴실 {
    public static void main(String[] args) {
        int[] enter = {1, 3, 2};
        int[] leave = {1, 2, 3}; // [0,1,1]
//        int[] enter = {1, 4, 2, 3};
//        int[] leave = {2, 1, 3, 4}; // [2,2,1,3]
//        int[] enter = {3, 2, 1};
//        int[] leave = {2, 1, 3}; // [1,1,2]
//        int[] enter = {3, 2, 1};
//        int[] leave = {1, 3, 2}; // [2,2,2]
//        int[] enter = {1, 4, 2, 3};
//        int[] leave = {2, 1, 4, 3}; // [2,2,0,2]

        int[] answerListV = listVer(enter, leave);
        int[] answerMapV = mapVer(enter, leave);

        Arrays.stream(answerListV).forEach(System.out::println);
    }

    private static int[] listVer(int[] enter, int[] leave){
        int N = enter.length, idx = 0;
        int[] answer = new int[N];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){

            list.add(enter[i]);

            for(int value : list){

                if(enter[i] == value)
                    answer[value - 1] = list.size() - 1;
                else
                    answer[value - 1]++;
            }

            while(idx < N && list.contains(leave[idx])){
                list.remove(Integer.valueOf(leave[idx++]));
            }
        }
        return answer;
    }

    private static int[] mapVer(int[] enter, int[] leave){
        int N = enter.length, idx = 0;
        int[] answer = new int[N];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){

            map.put(enter[i], enter[i]);

            if(map.size() > 1){

                for(int key : map.keySet())
                    answer[key - 1]++;

                answer[enter[i] - 1] += map.size() - 2;
            }

            while(idx < N && map.containsKey(leave[idx])){
                map.remove(leave[idx++]);
            }
        }

        return answer;
    }

}
