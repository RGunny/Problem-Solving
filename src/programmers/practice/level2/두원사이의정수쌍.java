package programmers.practice.level2;

public class 두원사이의정수쌍 {

    public static void main(String[] args) {
        long answer = solution(2, 3);// 20

        System.out.println("answer = " + answer);
    }

    public static long solution(int r1, int r2) {
        long answer = 0;

        // 중심은 원점
        // 각 원 위의 점 포함

        for(int i=1; i<=r2; i++){
            long min = (long)Math.ceil(Math.sqrt(1.0*r1 * r1 - 1.0 *i * i));
            long max = (long)Math.floor(Math.sqrt(1.0*r2 * r2 - 1.0 *i * i));
            answer += max - min + 1;
        }
        answer *= 4;

        return answer;
    }
}
