package programmers.weeklychellenge;

/**
 * 프로그래머스 위클리 챌린지 - 5주차
 * 모음 사전
 * https://programmers.co.kr/learn/courses/30/lessons/84512
 */
public class 모음사전 {
    private static char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    private static int count = 0;
    private static boolean isFind = false;

    public static void main(String[] args) {
        String word = "AAAAE"; // 6
//        String word = "AAAE"; // 10
//        String word = "I"; // 1563
//        String word = "EIO"; // 1189

        int answer = 0, mul = 781;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (vowel[j] == word.charAt(i))
                    answer += 1 + j * mul;
            }
            mul = (mul - 1) / 5;
        }

//        dfs(0, "", word);

        System.out.println(count);
    }

    private static void dfs(int depth, String next, String target) {
        if (depth > 5) return;

        if (next.equals(target)) {
            isFind = true;
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (isFind) return;

            if (depth + 1 < 6) count++;

            dfs(depth + 1, next + vowel[i], target);
        }
    }

    private static void otherSolution(String word) {
        int answer = 0, per = 3905;
        for (String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        System.out.println(answer);
    }
}
