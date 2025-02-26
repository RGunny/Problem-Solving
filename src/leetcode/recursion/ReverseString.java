package leetcode.recursion;

import java.util.stream.Stream;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        Stream.of(s).forEach(System.out::println);
        twoPointer(s);
        Stream.of(s).forEach(System.out::println);
    }

    private static void twoPointer(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
