package programmers.kakaoblind2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * 2018 KAKAO BLIND RECRUITMENT
 * 뉴스 클러스터링
 * https://programmers.co.kr/learn/courses/30/lessons/17677?language=java
 */
public class 뉴스클러스터링 {
    public static void main(String[] args) {
//        String str1 = "FRANCE", str2 = "french"; // 16384
//        String str1 = "handshake", str2 = "hand shake"; // 65536
//        String str1 = "aa1+aa2", str2 = "AAAA12"; // 43690
        String str1 = "E=M*C^2", str2 = "e=m*c^2"; // 65536

        int answer = 0;

        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        List<String> inter = new ArrayList<>();
        List<String> union = new ArrayList<>();

        String filter = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str1.length() - 1; i++) {
            if (filter.contains(String.valueOf(str1.charAt(i))) && filter.contains(String.valueOf(str1.charAt(i + 1))))
                list1.add(str1.substring(i, i + 2));
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            if (filter.contains(String.valueOf(str2.charAt(i))) && filter.contains(String.valueOf(str2.charAt(i + 1))))
                list2.add(str2.substring(i, i + 2));
        }

        Collections.sort(list1);
        Collections.sort(list2);

        for (String s1 : list1) {
            if (list2.remove(s1))
                inter.add(s1);
            union.add(s1);
        }

        for (String s2 : list2)
            union.add(s2);

        double interSize = inter.size();
        double unionSize = union.size();

        answer = (unionSize == 0) ? 65536 : (int) (interSize / unionSize * 65536);

        System.out.println(answer);
        
    }
}
