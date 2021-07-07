package programmers.dev_matching_back_2021;

import java.util.HashMap;

/**
 * 2021 Dev-Matching: 웹 백앤드 개발
 * 다단계 칫솔 판매
 * https://programmers.co.kr/learn/courses/30/lessons/77486
 */
public class 다단계칫솔판매 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        go(enroll, referral, seller, amount);

    }

    private static void go(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int enrollLen = enroll.length;
        int sellerLen = seller.length;

        // Person 객체를 담는 people 해시맵 초기화
        HashMap<String, Person> people = new HashMap<>();
        int[] ans = new int[enrollLen];

        // 추천인이 없는 사람 추가
        people.put("-", new Person("-"));

        // 1. 트리 생성
        // 1.1 enroll 배열로 People 생성
        for (String name : enroll)
            people.put(name, new Person(name));

        // 1.2 referral 배열로 Person 객체 간 부모-자식 관계 초기화
        for (int i = 0; i < enrollLen; i++)
            people.get(enroll[i]).parent = people.get(referral[i]);

        // 2. 이익 계산
        for (int i = 0; i < sellerLen; i++)
            people.get(seller[i]).calcCost(amount[i] * 100);

        for (int i = 0; i < enrollLen; i++)
            ans[i] = people.get(enroll[i]).cost;

    }


    private static class Person {
        String name;
        Person parent;
        int cost;

        public Person(String name) {
            this.name = name;
            this.parent = null;
            this.cost = 0;
        }

        public void calcCost(int cost) {
            int costParent = cost / 10; // 부모에게 줄 이득

            if (costParent != 0 && this.parent != null) {
                this.cost += cost - costParent;
                this.parent.calcCost(costParent);
            } else {
                this.cost += cost;
            }
        }
    }

}
