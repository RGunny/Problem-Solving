package codility.lessons._2_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Codility
 * Lessions 2 - Arrays
 * https://app.codility.com/programmers/lessons/2-arrays/
 */
public class CyclicRotation {

    private int[] solution1(int[] A, int K) {
        int length = A.length;
        if (length == 0 ) return A;
        int rotateNum = getRotateNum(length, K);
        getRotatedArr(A, length, rotateNum);

        return A;
    }

    private int[] solution2(int[] A, int K) {
        int[] rotatedArr = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            rotatedArr[(i + K) % A.length] = A[i];
        }
        return rotatedArr;
    }

    private void getRotatedArr(int[] A, int length, int rotateNum) {
        for (int i = 0; i < rotateNum; i++) {
            int temp = A[length - 1];
            for (int j = length - 1; j > 0; j--) {
                A[j] = A[j - 1];
            }
            A[0] = temp;
        }
    }

    private int getRotateNum(int length, int K) {
        return K % length;
    }

    @Test
    void test() {
        assertArrayEquals(solution1(new int[]{3, 8, 9, 7, 6}, 3), new int[]{9, 7, 6, 3, 8});
        assertArrayEquals(solution1(new int[]{0, 0, 0}, 1), new int[]{0, 0, 0});
        assertArrayEquals(solution1(new int[]{1, 2, 3, 4}, 4), new int[]{1, 2, 3, 4});
        assertArrayEquals(solution1(new int[]{0}, 5), new int[]{0});
        assertArrayEquals(solution2(new int[]{3, 8, 9, 7, 6}, 3), new int[]{9, 7, 6, 3, 8});
        assertArrayEquals(solution2(new int[]{0, 0, 0}, 1), new int[]{0, 0, 0});
        assertArrayEquals(solution2(new int[]{1, 2, 3, 4}, 4), new int[]{1, 2, 3, 4});
        assertArrayEquals(solution2(new int[]{0}, 5), new int[]{0});
    }
}
