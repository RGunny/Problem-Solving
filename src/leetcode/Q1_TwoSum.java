package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class Q1_TwoSum {

    public static void main(String[] args) {
        runTests(Q1_TwoSum::twoSum);
        runTests(Q1_TwoSum::twoSum2);
    }

    public static void runTests(BiFunction<int[], Integer, int[]> solution) {
        assertArrayEquals(new int[]{0, 1}, solution.apply(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, solution.apply(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, solution.apply(new int[]{3, 3}, 6));
    }

    /**
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

}
