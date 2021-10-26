package programmers.weeklychellenge;

/**
 * 프로그래머스 위클리 챌린지 - 8주차
 * 최소직사각형
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 */
public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}; // 4000

        int answer = getSize(sizes);

        System.out.println("answer = " + answer);
    }

    private static int getSize(int[][] sizes){
        int width = 0, height = 0;
        for(int[] size : sizes){

            width = Math.max(width, (Math.max(size[0], size[1])));
            height = Math.max(height, (Math.min(size[0], size[1])));
        }

        return width * height;
    }
}
