package programmers.kakaoblind2018;

/**
 * 2018 KAKAO BLIND RECRUITMENT
 * 추석 트래픽
 * https://programmers.co.kr/learn/courses/30/lessons/17676
 */
public class 추석트래픽 {
    public static void main(String[] args) {
//        String[] lines = {"2016-09-15 01:00:04.001 2.0s",
//                "2016-09-15 01:00:07.000 2s"}; // 1
        String[] lines = {"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"}; // 2
//        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
//                "2016-09-15 20:59:58.233 1.181s",
//                "2016-09-15 20:59:58.299 0.8s",
//                "2016-09-15 20:59:58.688 1.041s",
//                "2016-09-15 20:59:59.591 1.412s",
//                "2016-09-15 21:00:00.464 1.466s",
//                "2016-09-15 21:00:00.741 1.581s",
//                "2016-09-15 21:00:00.748 2.31s",
//                "2016-09-15 21:00:00.966 0.381s",
//                "2016-09-15 21:00:02.066 2.62s"}; // 7

        int N = lines.length;
        int[] startTimes = new int[N];
        int[] endTimes = new int[N];

        getTimes(lines, startTimes, endTimes, N);

        int answer = getMax(startTimes, endTimes, N);

        System.out.println(answer);
    }

    /**
     * 각 로그마다(N) 처음과 끝나는 시점을(2) 기준으로 다른 로그들을(N) 파악
     * => N * 2 * N
     * => O(N^2)
     */
    private static int getMax(int[] startTimes, int[] endTimes, int N) {
        int answer = 0; // Maximum throughput per second
        for (int i = 0; i < N; i++) {
            int count = 0;
            int start = endTimes[i];
            int end = start + 1000;

            for (int j = 0; j < N; j++) {
                if(startTimes[j] >= start && startTimes[j] < end) count++;
                else if(endTimes[j] >= start && endTimes[j] < end) count++;
                else if (startTimes[j] <= start && endTimes[j] >= end) count++;
            }
            answer = count > answer ? count : answer;
        }

        return answer;
    }

    private static void getTimes(String[] lines, int[] startTimes, int[] endTimes, int N) {

        for (int i = 0; i < N; i++) {
            // YYYY-MM-DD, HH:MM:SS.MSS, X.XXXs
            String[] log = lines[i].split(" ");
            int endTime = getSeconds(log[1]);
            int processingTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            int startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }

    private static int getSeconds(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60 * 60 * 1000) // hh
                + (Integer.parseInt(t[1]) * 60 * 1000) // mm
                + (int) (Double.parseDouble(t[2]) * 1000); // ss
    }


}
