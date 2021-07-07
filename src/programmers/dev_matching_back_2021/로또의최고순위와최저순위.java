package programmers.dev_matching_back_2021;

import java.util.Arrays;

/**
 * 2021 Dev-Matching: 웹 백앤드 개발
 * 로또의 최고 순위와 최저 순위
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 */
public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int zeroNum = getZeroNum(lottos, win_nums);
        int minNum = getMinNum(lottos, win_nums);

        int minRank = getRank(minNum);
        int highRank = getRank(minNum + zeroNum);

        int[] ans = {minRank, highRank};

        System.out.println("minRank = " + minRank);
        System.out.println("highRank = " + highRank);
    }

    /**
     * 로또의 순위를 구하는 메서드
     */
    private static int getRank(int num) {
        switch (num) {
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 6;
        }
    }

    /**
     * lottos 배열에서 0을 제외하고 당첨 번호와 일치하는 원소의 개수를 구하는 메서드
     */
    private static int getMinNum(int[] lottos, int[] win_nums) {
        int cnt = 0;
        for (int lotto : lottos) {
            for (int winNum : win_nums) {
                if (lotto == 0) continue;

                if (lotto == winNum) cnt += 1;
            }
        }
        return cnt;
    }

    /**
     * lottos 배열의 0의 개수를 구하는 메서드
     */
    private static int getZeroNum(int[] lottos, int[] win_nums) {
        int cnt = 0; // the number of zero
        Arrays.sort(lottos);
        for (int lotto : lottos) {
            if (lotto == 0)
                cnt += 1;
            else
                break;
        }
        return cnt;
    }
}
