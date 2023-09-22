package leetcode.Arrays;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** <a href="https://leetcode.com/problems/3sum/">...</a>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * {@link ThreeSumClosest} related problems
 * solved using TWO POINTERS
 */
public class ThreeSumZero {
    public List<List<Integer>> solveWithSet(int[] nums) {
        Set<List<Integer>> tripletList = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) tripletList.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else j++;
            }
        }
        return new ArrayList<>(tripletList);
    }

    public List<List<Integer>> solveWithoutSet(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tripletList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //skipping duplicates
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;    //Skipping duplicates
                    while (j < k && nums[k] == nums[k + 1]) k--;
                    tripletList.add(Arrays.asList(nums[i], nums[j - 1], nums[k + 1]));
                } else if (sum > 0) k--;
                else j++;
            }
        }
        return tripletList;
    }
}
