package leetcode;

import java.util.Arrays;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/3sum-closest/description/
 */
public class Q16_3SumClosest {

    public static void main(String[] args) {
        runTests(Q16_3SumClosest::threeSumClosest);
    }

    public static void runTests(BiFunction<int[], Integer, Integer> solution) {
        assertEquals(2, solution.apply(new int[]{-1, 2, 1, -4}, 1));
        assertEquals(0, solution.apply(new int[]{0, 0, 0}, 1));
        assertEquals(3, solution.apply(new int[]{1, 1, 1, 1}, 2));
        assertEquals(82, solution.apply(new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33, 39, 45, 56, 69, 74, 81, 90}, 82));
    }

    /**
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     * Algorithm : Sort, Two Pointer
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int length = nums.length;
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < length - 2; i++) {
            int left = i + 1, right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else { // sum == target
                    return sum;
                }
            }
        }
        return closest;
    }
}
