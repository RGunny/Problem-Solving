package programmers.kits.hash;

import java.util.Arrays;

/**
 * 해시
 * Level 2
 * 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 */
public class 전화번호목록 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        if (hasPrefix(phone_book)) {
            System.out.println("false");
        }else{
            System.out.println("true");
        }
    }

    /**
     * 1. 정렬
     * 2. 연속된 문자가 접두어인지 확인
     */
    private static boolean hasPrefix(String[] phone_book) {
        Arrays.sort(phone_book);
        int len = phone_book.length;
        for (int i = 1; i < len; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) {
                return false;
            }
        }
        return true;
    }
}
