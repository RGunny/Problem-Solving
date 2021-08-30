package programmers.kits.graph;

/**
 * 그래프
 * Level 3
 * 순위
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */
public class 순위 {

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        int[][] scores = new int[n][n];

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0] - 1;
            int looser = results[i][1] - 1;
            scores[winner][looser] = 1;
            scores[looser][winner] = -1;
        }

        int certainGame = floyd(n, scores);

        System.out.println(certainGame);
    }

    /**
     * 플로이드 워셜 O(N^3)
     * => 거쳐가는 정점을 기준으로 최단거리를 구함
     */
    private static int floyd(int n, int[][] scores){

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if(i == j || scores[i][j] != 0) continue;

                    // i->k, k->j => i-j
                    if(scores[i][k] == scores[k][j])
                        scores[i][j] = scores[i][k];
                }
            }
        }

        int certainGame = 0;
        loop : for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(scores[i][j] == 0 && i != j)
                    continue loop;
            }
            certainGame++;
        }

        return certainGame;
    }

}
