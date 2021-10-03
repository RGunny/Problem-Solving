package programmers.kits.dp;

/**
 * 동적 프로그래밍
 * Level 4
 * 도둑질
 * https://programmers.co.kr/learn/courses/30/lessons/42897
 */
public class 도둑질 {
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1}; // 4

        int answer = solution(money);

        System.out.println(answer);
    }

    public static int solution(int[] money) {

        int N = money.length;
        if (N == 0) return 0;

        int[] dp1 = new int[N + 2];
        int[] dp2 = new int[N + 2];
        dp1[1] = money[0];
        dp1[2] = money[0];
        dp2[2] = money[1];

        for (int i = 3; i <= N; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i - 1], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + money[i - 1], dp2[i - 1]);
        }

        return Math.max(dp1[N - 1], dp2[N]);
    }
}
