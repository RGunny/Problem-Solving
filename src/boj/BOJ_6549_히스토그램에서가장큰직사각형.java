package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 스택
 * Platinum 5
 * 히스토그램에서 가장 큰 직사각형
 * https://www.acmicpc.net/problem/6549
 */
public class BOJ_6549_히스토그램에서가장큰직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 히스토그램의 가로 칸 수

            if (N == 0) break;

            int[] heights = new int[N];
            for (int i = 0; i < N; i++)
                heights[i] = Integer.parseInt(st.nextToken());

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
}
