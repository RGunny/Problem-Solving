package programmers.practice;

/**
 * 연습문제
 * 2016년
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class 특정요일구하기_2016년 {
    /**
     * 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
     * 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴
     *
     * 2016년은 윤년입니다.
     * 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
     */
    public static void main(String[] args) {

        int a = 5, b = 24; // "TUE"

        int sumDate = getSumDate(a, b);
        String dayOfTheWeek = getDayOfTheWeek(sumDate);

        System.out.println(dayOfTheWeek);
    }

    private static String getDayOfTheWeek(int sumDate){
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        return days[sumDate % 7];
    }

    private static int getSumDate(int month, int day){
        int[] lastDates = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sumDate = 0;
        for(int i=0; i<month - 1; i++)
            sumDate += lastDates[i];

        sumDate += day - 1;
        return sumDate;
    }
}
