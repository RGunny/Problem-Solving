package programmers.kits.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 깊이/너비 우선 탐색(DFS/BFS)
 * Level 2
 * 타겟 넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class 타겟넘버 {
    private static int count;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

//        dfs(numbers, target, 0, 0);
        int answer = bfs(numbers, target);

        System.out.println("count = " + count);
        System.out.println("answer = " + answer);
    }

    private static void dfs(int[] numbers, int target, int depth, int sum) {

        if (depth == numbers.length) {
            if (sum == target)
                count += 1;
            return;
        }

        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);

    }

    private static int bfs(int[] numbers, int target) {
        int count = 0;
        Queue<Number> q = new LinkedList<>();
        q.offer(new Number(numbers[0], 0));
        q.offer(new Number(-numbers[0], 0));

        while (!q.isEmpty()) {
            Number p = q.poll();
            if (p.index == numbers.length - 1) {
                if (p.sum == target)
                    count += 1;
                continue;
            }

            q.add(new Number(p.sum + numbers[p.index + 1], p.index + 1));
            q.add(new Number(p.sum - numbers[p.index + 1], p.index + 1));
        }
        return count;
    }

    private static class Number {
        int sum;
        int index;

        Number(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

}
