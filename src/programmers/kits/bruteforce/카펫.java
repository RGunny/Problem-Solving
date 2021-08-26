package programmers.kits.bruteforce;

/**
 * 완전 탐색(Brute Force)
 * Level 2
 * 카펫
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
public class 카펫 {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2; // {4, 3}

        int[] answer = getCarpet(brown, yellow);

        System.out.println(answer[0] + " " + answer[1]);
    }


    /**
     brown : 2x + 2y - 4
     yellow : (x - 2) * (y - 2)
     return {width, height}
     */
    private static int[] getCarpet(int brown, int yellow){

        int height = 0, width = 0;

        for(height = 3; height <= (int) (brown + 4) / 2; height++){

            width = ((brown + 4) / 2) - height;
            if(width < height) break;

            int yellowCnt = (width - 2) * (height - 2);
            if(yellowCnt == yellow) break;
        }

        return new int[] {width, height};
    }
}
