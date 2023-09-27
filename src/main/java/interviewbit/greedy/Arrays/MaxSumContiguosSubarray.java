package interviewbit.greedy.Arrays;

/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * https://leetcode.com/problems/maximum-subarray/
 * Find the maximum sum of contiguous non-empty subarray within an array A of length N.
 * <p>
 * Problem Constraints
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 * <p>
 * Input Format
 * The first and the only argument contains an integer array, A.
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, -10]
 * Input 2:
 * A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * <p>
 * Example Output
 * Output 1:
 * 10
 * Output 2:
 * 6
 * <p>
 * Example Explanation
 * Explanation 1:
 * The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * Explanation 2:
 * The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaxSumContiguosSubarray {
    /**
     * Related Problems :
     * {@link Flip}
     * {@link MaxSumContiguosSubarray}
     * Kadane's Algorithm
     * Step 1: do summation of current element
     * Step 2: update maxSum if it is smaller than current sum
     * Step 3: update sum if it is smaller than 0
     */
    public int solve(int[] A) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : A) {
            sum += num;

            maxSum = Math.max(maxSum, sum);
            //if(maxSum<sum) maxSum = sum;

            sum = Math.max(sum, 0);
            //if(sum<0) sum = 0;
        }
        return maxSum;
    }
}
