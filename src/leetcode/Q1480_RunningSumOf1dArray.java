package leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Q1480_RunningSumOf1dArray {

    public static void main(String[] args) {
        assertAll(new int[]{1, 3, 6, 10}, new int[]{1, 2, 3, 4});
        assertAll(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 1, 1});
        assertAll(new int[]{3, 4, 6, 16, 17}, new int[]{3, 1, 2, 10, 1});

        // 엣지 케이스
        assertAll(new int[]{}, new int[]{});
        assertAll(new int[]{-5}, new int[]{-5});
        assertAll(new int[]{1, -1, 2, -2}, new int[]{1, -2, 3, -4});
    }

    public static void assertAll(int[] expected, int[] input) {
        assertArrayEquals(expected, iterativeRunningSum(input));
        assertArrayEquals(expected, recursiveRunningSum(input));
        assertArrayEquals(expected, inplaceRunningSum(input));
    }

    public static int[] recursiveRunningSum(int[] nums) {
        int[] result = new int[nums.length];
        recursive(nums, result, 0, 0);
        return result;
    }

    public static void recursive(int[] nums, int[] result, int index, int sum) {
        if (index == nums.length) return;

        sum += nums[index];
        result[index] = sum;

        recursive(nums, result, index + 1, sum);
    }

    public static int[] iterativeRunningSum(int[] nums) {
        int[] result = new int[nums.length];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }

    public static int[] inplaceRunningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
