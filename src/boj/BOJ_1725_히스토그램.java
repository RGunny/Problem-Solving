package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택
 * Platinum 5
 * 히스토그램
 * https://www.acmicpc.net/problem/5569
 */
public class BOJ_1725_히스토그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 히스토그램의 가로 칸 수

        int[] heights = new int[N];
        for (int i = 0; i < N; i++)
            heights[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>(); // index를 넣는 스택
        long maxArea = 0; // 가장 큰 넓이

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int index = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) width * heights[index]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int width = stack.isEmpty() ? N : N - stack.peek() - 1;
            maxArea = Math.max(maxArea, (long) width * heights[index]);
        }

        System.out.println(maxArea);
    }
}
