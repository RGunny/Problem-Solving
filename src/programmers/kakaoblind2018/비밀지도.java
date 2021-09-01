package programmers.kakaoblind2018;

/**
 * 2018 KAKAO BLIND RECRUITMENT
 * 비밀지도
 * https://programmers.co.kr/learn/courses/30/lessons/17681?language=java
 */
public class 비밀지도 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28}; // ["#####","# # #", "### #", "# ##", "#####"]
//        int n = 6;
//        int[] arr1 = {46, 33, 33 ,22, 31, 50};
//        int[] arr2 = {27 ,56, 19, 14, 14, 10}; // ["######", "### #", "## ##", " #### ", " #####", "### # "]

        String[] map = new String[n];

        for (int i = 0; i < n; i++) {

            String a = decimalToBinary(arr1[i], n);
            String b = decimalToBinary(arr2[i], n);

            String line = "";
            for (int j = 0; j < n; j++)
                line += (a.charAt(j) == '#' || b.charAt(j) == '#') ? "#" : " ";

            map[i] = line;
        }


        for(String s : map)
            System.out.println(s);
    }

    private static String decimalToBinary(int num, int length){
        String s = "";

        while (num != 0) {
            s = (num % 2 == 1) ? "#" + s : " " + s;
            num /= 2;
        }

        while(s.length() != length)
            s = " " + s;

        return s;
    }
}
