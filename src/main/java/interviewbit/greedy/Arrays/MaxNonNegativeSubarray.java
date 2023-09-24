package interviewbit.greedy.Arrays;

import java.util.ArrayList;

/**
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 * <p>
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * <p>
 * Find and return the required subarray.
 * <p>
 * NOTE:
 * <p>
 * 1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 * 2. If there is still a tie, then return the segment with minimum starting index.
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument of input contains an integer array A, of length N.
 * Output Format:
 * <p>
 * Return an array of integers, that is a subarray of A that satisfies the given conditions.
 * Constraints:
 * <p>
 * 1 <= N <= 1e5
 * -INT_MAX < A[i] <= INT_MAX
 * Examples:
 * <p>
 * Input 1:
 * A = [1, 2, 5, -7, 2, 3]
 * <p>
 * Output 1:
 * [1, 2, 5]
 * <p>
 * Explanation 1:
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3].
 * <p>
 * Input 2:
 * A = [10, -1, 2, 3, -4, 100]
 * <p>
 * Output 2:
 * [100]
 * <p>
 * Explanation 2:
 * The three sub-arrays are [10], [2, 3], [100].
 * The answer is [100] as its sum is larger than the other two.
 */
public class MaxNonNegativeSubarray {
    public int[] solve(int[] A) {
        long sum = 0, maxSum = 0;
        int s = 0, maxS = 0, maxE = 0;
        int flag = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) sum += A[i];
            else {
                sum = 0;
                s = i + 1;
            }

            if (maxSum < sum) {
                maxSum = sum;
                maxE = i;
                maxS = s;
                flag = 1;
            } else if (maxSum == sum && (maxE - maxS + 1) < (i - s + 1) && A[i] >= 0) {
                maxS = s;
                maxE = i;
                flag = 1;
            }
        }
        if (flag == 0) return new int[]{};
        int[] res = new int[maxE - maxS + 1];
        for (int i = 0; i < res.length; i++)
            res[i] = A[maxS + i];
        return res;
    }

    public ArrayList<Integer> solveWithArrayList(ArrayList<Integer> A) {
        //TODO
        return null;
    }
}
