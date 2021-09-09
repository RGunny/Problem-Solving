package programmers.weeklychellenge;

import java.util.*;

/**
 * 프로그래머스 위클리 챌린지 - 6주차
 * 복서 정렬하기
 * https://programmers.co.kr/learn/courses/30/lessons/85002
 */
public class 복서정렬하기 {
    public static void main(String[] args) {
//        int[] weights = {50, 82, 75, 120};
//        String[] head2head = {"NLWL", "WNLL", "LWNW", "WWLN"}; // [3,4,1,2]
//        int[] weights = {145,92,86};
//        String[] head2head = {"NLW","WNL","LWN"}; // [2,3,1]
        int[] weights = {60,70,60};
        String[] head2head = {"NNN","NNN","NNN"}; // [2,1,3]

        int N = weights.length;
        int[] answer = new int[N];
        List<Boxer> boxers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int winCount = 0, winHeavierCount = 0, fightCount = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if(head2head[i].charAt(j) != 'N') fightCount++;
                if (head2head[i].charAt(j) == 'W') {
                    winCount++;
                    if (weights[i] < weights[j]) winHeavierCount++;
                }
            }

            boxers.add(new Boxer(i, weights[i], winHeavierCount, (double) winCount / fightCount));
        }

        Collections.sort(boxers);

        for (int i = 0; i < N; i++) {
            answer[i] = boxers.get(i).index + 1;
            System.out.println(answer[i]);
        }
    }

    private static class Boxer implements Comparable<Boxer> {
        int index, weight, winHeavierCount;
        double rating;

        public Boxer(int index, int weight, int winHeavierCount, double rating) {
            this.index = index;
            this.weight = weight;
            this.winHeavierCount = winHeavierCount;
            this.rating = rating;
        }

        @Override
        public int compareTo(Boxer o) {
//         1. 전체 승률이 높은 복서의 번호가 앞쪽으로 갑니다. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
//         => 승률 내림차순 정렬, 승률은 0으로 초기화
            if (o.rating - rating > 0) return 1;
            else if (o.rating - rating < 0) return -1;
            else {
//         2. 승률이 동일한 복서의 번호들 중에서는 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
//         => 자신의 무게보다 무거운 복서를 이긴 횟수를 담은 카운트를 바탕으로 동일 승률에서 우선순위를 생성
                if (o.winHeavierCount - winHeavierCount > 0) return 1;
                else if (o.winHeavierCount - winHeavierCount < 0) return -1;
                else {
//         3. 자신보다 무거운 복서를 이긴 횟수까지 동일한 복서의 번호들 중에서는 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
//         => 2. 까지 동일한 경우 몸무게가 무거운 복서가 우선 => 몸무게 내림차순 정렬로 초기화하면 해결될 듯
                    if (o.weight - weight > 0) return 1;
                    else if (o.weight - weight < 0) return -1;
                    else {
//         4. 자기 몸무게까지 동일한 복서의 번호들 중에서는 작은 번호가 앞쪽으로 갑니다.
//         => 몸무게가 동일하면
                        if (o.index - index < 0) return 1;
                        else return -1;
                    }
                }
            }
        }
    }
}
