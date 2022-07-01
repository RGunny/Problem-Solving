package programmers.kakaoblind2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고결과받기 {
    // {신고당한 user : Set<신고한 유저의 아이디>}
    private static Map<String, HashSet<String>> map = new HashMap<>();
    // {user : index}
    private static Map<String, Integer> idxMap = new HashMap<>();

    public static void main(String[] args) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//        int k = 2; // [2,1,1,0]
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3; // [0,0]

        int[] answer = solution(id_list, report, k);
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

    private static int[] solution(String[] id_list, String[] reports, int k) {
        // init
        for (int i=0; i<id_list.length; i++){
            String user = id_list[i];
            map.put(user, new HashSet<>());
            idxMap.put(user, i);
        }

        //
        for (String report : reports) {
            String[] splited = report.split(" ");
            String from = splited[0];
            String to = splited[1];

            map.get(to).add(from);
        }

        // 이용 정지 유저를 (k이상 신고당함) 몇 명이 신고 했는 지
        int[] mailNum = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reporter = map.get(id_list[i]);

            if (reporter.size() >= k){
                for (String user : reporter){
                    mailNum[idxMap.get(user)]++;
                }
            }
        }

        return mailNum;
    }
}
