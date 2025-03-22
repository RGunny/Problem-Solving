package leetcode;

import java.util.*;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q15_3Sum {

    public static void main(String[] args) {
        runTests(Q15_3Sum::threeSum);
        runTests(Q15_3Sum::threeSum2);
    }

    public static void runTests(Function<int[], List<List<Integer>>> solution) {
        assertEquals(
                List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                solution.apply(new int[]{-1, 0, 1, 2, -1, -4})
        );
        assertEquals(
                List.of(),
                solution.apply(new int[]{0, 1, 1})
        );
        assertEquals(
                List.of(List.of(0, 0, 0)),
                solution.apply(new int[]{0, 0, 0})
        );
    }

    /**
     * Time Complexity : O(n^3)
     * Space Complexity : O(1)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(Comparator.naturalOrder());
                        result.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }


    /**
     * Time Complexity : O(n^2)
     * Space Complexity : O(n)
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // 중복된 값 스킵
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
