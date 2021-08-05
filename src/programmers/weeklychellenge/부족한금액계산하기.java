package programmers.weeklychellenge;

/**
 * 프로그래머스 위클리 챌린지
 * 부족한 금액 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class 부족한금액계산하기 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        long answer = money;
        int cnt = 1;
        while (count-- > 0) {
            long fee = price * cnt++;
            money -= fee;
        }

        answer = answer >= 0 ? 0 : (answer * -1);
        System.out.println("answer = " + answer);
    }

}
