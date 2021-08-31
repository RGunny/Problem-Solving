package programmers.kakaoblind2018;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2018 KAKAO BLIND RECRUITMENT
 * 셔틀버스
 * https://programmers.co.kr/learn/courses/30/lessons/17678?language=java
 */
public class 셔틀버스 {
    public static void main(String[] args) {
//        int n = 1, t = 1, m = 5;
//        String[] timetable = {"08:00", "08:01", "08:02", "08:03"}; // "09:00"
//        int n = 2, t = 10, m = 2;
//        String[] timetable = {"09:10", "09:09", "08:00"}; // "09:09"
//        int n = 2, t = 1, m = 2;
//        String[] timetable = {"09:00", "09:00", "09:00", "09:00"}; // "08:59"
//        int n = 1, t = 1, m = 5;
//        String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"}; // "00:00"
//        int n = 1, t = 1, m = 1;
//        String[] timetable = {"23:59"}; // "09:00"
        int n = 10, t = 60, m = 45;
        String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}; // "18:00"

        String answer = "";
        int length = timetable.length;

//        Arrays.sort(timetable, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        int[] times = getSeconds(timetable, length);
        PriorityQueue<Integer> crews = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int time : times)
            crews.add(time);

        // 현재 버스 시간, 마지막 탑승한 승객의 시간
        int curBus = 540, lastBoarding = 0;

        while(n-- > 0){

            int seat = m; // 남은 좌석
            int time = 0; // 마지막 탑승한 크루의 시간

            while (!crews.isEmpty()) {
                // 가장 빨리 탑승하는 크루가 버스보다 일찍 오고 좌석도 있으면
                if (crews.peek() <= curBus && seat > 0) {
                    seat --;
                    time = crews.poll();
                } else break;
            }

            // 마지막 버스가 아니면
            if (n > 0) {
                // 내가 마지막이면
                if (crews.isEmpty()) {
                    // 마지막 버스의 도착 시간
                    lastBoarding = 540 + n * t;
                    break;
                }
                curBus += t;
            }
            // 마지막 버스면
            else {
                if(seat > 0) lastBoarding = curBus;
                // 마지막 크루보다 1분 앞서서 탑승
                else lastBoarding = time - 1;
            }
        }

        answer = secondsToDate(lastBoarding);
        System.out.println(answer);
    }

    private static String secondsToDate(int seconds){
        String hour = String.valueOf(seconds / 60);
        String minute = String.valueOf(seconds % 60);
        hour = hour.length() < 2 ? "0" + hour : hour;
        minute = minute.length() < 2 ? "0" + minute : minute;
        return String.valueOf(hour + ":" + minute);
    }

    private static int[] getSeconds(String[] timetable, int length){
        int[] times = new int[length];
        for(int i=0; i<length; i++)
            times[i] = Integer.parseInt(timetable[i].substring(0, 2)) * 60
                    + Integer.parseInt(timetable[i].substring(3, 5));

        return times;
    }
}
