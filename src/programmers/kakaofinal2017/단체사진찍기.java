package programmers.kakaofinal2017;

import java.util.HashMap;

public class 단체사진찍기 {
    private final static char[] letters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static HashMap<Character, Integer> map = new HashMap<>();
    private static boolean[] visited = new boolean[8];
    private static int[] positions = new int[8];
    private static int count = 0;
    private static String[] datas;

    public static void main(String[] args) {
//        int n = 2;
//        String[] data = {"N~F=0", "R~T>≠2"}; // 3648
        int n = 2;
        String[] data = {"M~C<2", "C~M>1"}; // 0

        datas = data;

        for(int i=0; i<8; i++){
            map.put(letters[i], i);
        }

        perm(0);

        System.out.println("count = " + count);
    }

    private static void perm(int depth){
        if(depth == 8){
            if(isRight()) count++;
        }else{
            for(int i=0; i<8; i++){
                if(!visited[i]){
                    visited[i] = true;
                    positions[depth] = i;
                    perm(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean isRight(){
        for (String letter : datas){
            int position1 = positions[map.get(letter.charAt(0))];
            int position2 = positions[map.get(letter.charAt(2))];
            char op = letter.charAt(3);
            int res = letter.charAt(4) - '0' + 1;
            int dist = Math.abs(position1-position2);

            if(op == '='){
                if(dist != res) return false;
            }
            else if(op == '>'){
                if(dist <= res) return false;
            }
            else {
                if(dist >= res) return false;
            }
        }
        return true;
    }
}
