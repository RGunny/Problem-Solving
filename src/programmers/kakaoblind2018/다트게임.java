package programmers.kakaoblind2018;

/**
 * 2018 KAKAO BLIND RECRUITMENT
 * 다크 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */
public class 다트게임 {
    public static void main(String[] args) {
//        String dartResult = "1S2D*3T"; // 37
        String dartResult = "1D2S#10S"; // 9
//        String dartResult = "1D2S0T"; // 3
//        String dartResult = "1S*2T*3S"; // 23
//        String dartResult = "1D#2S*3S"; // 5
//        String dartResult = "1T2D3D#"; // -4
//        String dartResult = "1D2S3T*"; // 59

        int answer = 0;

        int[] scores = new int[3];
        // 1. 다트판에 다트를 세 차례 던진다.
        int index = 0;
        int length = dartResult.length();
        for (int i = 0; i < length; ++i) {

            char cur = dartResult.charAt(i);
            if (i != length - 1 && Character.getNumericValue(cur) >= 0 && Character.getNumericValue(cur) <= 9
                    && Character.getNumericValue(dartResult.charAt(i + 1)) == 0) {
                scores[index++] = 10;
                i++;
                continue;
            }
//            String s = String.valueOf(dartResult.charAt(i)) + String.valueOf(dartResult.charAt(i + 1));

            switch (cur) {
                case 'S':

                    break;
                case 'D':
                    scores[index - 1] = (int) Math.pow(scores[index - 1], 2);
                    break;
                case 'T':
                    scores[index - 1] = (int) Math.pow(scores[index - 1], 3);
                    break;
                case '*':
                    if (index == 1)
                        scores[index - 1] *= 2;
                    else {
                        scores[index - 2] *= 2;
                        scores[index - 1] *= 2;
                    }
                    break;
                case '#':
                    scores[index - 1] *= -1;
                    break;
                default:
                    scores[index++] = Character.getNumericValue(cur);
            }
        }

        for (int score : scores)
            answer += score;

        System.out.println(answer);
    }
}
