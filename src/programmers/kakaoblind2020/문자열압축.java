package programmers.kakaoblind2020;

/**
 * 2020 KAKAO BLIND RECRUITMENT
 * 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class 문자열압축 {
    public static void main(String[] args) {
        String s = "aabbaccc"; // 7
//        String s = "ababcdcdababcdcd"; // 9
//        String s = "abcabcabcabcdededededede"; // 14


        int minLength = getAns(s, s.length());
        System.out.println(minLength);
    }


    private static int getAns(String s, int size) {
        String minString = "A".repeat(1001);

        if (size == 1) return 1;

        for (int i = 1; i <= size / 2; i++) {
            String str = ""; // 압축 길이 별 문자열 변수
            String temp = ""; // 자른 문자열을 비교 할 변수
            int count = 1; // 자른 문자열의 개수를 카운팅 할 변수

            for (int j = 0; j < size / i; j++) {
                // 이전 문자열과 현재 문자열이 비교 후 카운팅
                String substring = s.substring(i * j, (i * j) + i);
                if (temp.equals(substring)) {
                    count += 1;
                    continue;
                }

                // count가 1 초과 => "count" + "temp" 추가 후 count 초기화
                if (count > 1) {
                    str += count + temp;
                    count = 1;
                }

                // 아니면 temp만 추가
                else
                    str += temp;

                // 현재 자른 문자열로 비교대상 변경
                temp = substring;
            }

            // 마지막에 붙이지 못한 문자열을 붙임
            if (count > 1) {
                str += count + temp;
                count = 1;
            } else
                str += temp;

            // s의 길이가 압축하는 길이로 나누어지지 않으면 => 나머지 부분부터 마지막까지 추가
            if (s.length() % i != 0)
                str += s.substring(size - size % i, size);

            minString = minString.length() > str.length() ? str : minString;
        }

        return minString.length();
    }
}
