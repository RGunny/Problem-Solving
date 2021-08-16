package programmers.weeklychellenge;

/**
 * 프로그래머스 위클리 챌린지 - 2주차
 * 상호 평가
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 */
public class 상호평가 {
    private static int N;

    public static void main(String[] args) {
        int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}}; // "FBABD"
//        int[][] scores = {{50,90},{50,87}}; // "DA"
//        int[][] scores = {{70,49,90},{68,50,38},{73,31,100}}; // "CFD"

        float[] averages = calcScore(scores);
        String grade = getGrade(averages);

        for (int i = 0; i < averages.length; i++)
            System.out.print(averages[i] + "  ");

        System.out.println(grade);
    }

    private static float[] calcScore(int[][] scores) {

        N = scores.length;

        float[] averages = new float[N];

        for (int i = 0; i < N; i++) {
            int max = -1, min = 101, sum = 0, cnt = 0;
            boolean isFlag = false;
            for (int j = 0; j < N; j++) {
                max = Math.max(max, scores[j][i]);
                min = Math.min(min, scores[j][i]);

                sum += scores[j][i];
            }

            if ((scores[i][i] == max || scores[i][i] == min)) {
                if (isUnique(scores, i, scores[i][i])) {
                    sum -= scores[i][i];
                    isFlag = true;
                }
            }

            if (isFlag) averages[i] = sum / (N - 1);
            else averages[i] = sum / N;
        }

        return averages;
    }

    private static String getGrade(float[] averages) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            float average = averages[i];
            sb.append(average >= 90 ? "A" : average >= 80 ? "B" : average >= 70 ? "C" : average >= 50 ? "D" : "F" );
        }

        return sb.toString();
    }

    private static boolean isUnique(int[][] scores, int index, int score) {

        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (scores[i][index] == score) cnt += 1;

        return cnt < 2 ? true : false;
    }
}
