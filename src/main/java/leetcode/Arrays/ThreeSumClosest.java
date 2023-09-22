package leetcode.Arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/">...</a>
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * <p>
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * {@link ThreeSumZero } related problems
 */
public class ThreeSumClosest {
    public int solve(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(target - closestSum);
        for (int i = 0; i + 2< nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int currDiff = Math.abs(target - sum);
                if (currDiff < minDiff) { // keep track of the closest element to the target
                    minDiff = currDiff;
                    closestSum = sum;
                }

                if (sum == target) return target;
                else if (sum < target) j++;
                else k--;
            }
        }
        return closestSum;
    }
}
