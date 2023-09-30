package interviewbit.greedy.Arrays;

/**
 * Maximum Sum Rectangle In A 2D Matrix
 * Given a N * M 2D matrix A. Find the maximum sum sub-matrix from the matrix A. Return the Sum.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 300
 * -104 <= A[i][j] <= 104
 * <p>
 * <p>
 * Input Format
 * The first argument is a 2D Integer array A.
 * <p>
 * <p>
 * Output Format
 * Return the sum of the maximum sum sub-matrix from matrix A.
 * <p>
 * <p>
 * Example Input
 * Input 1:-
 * A = -6 -6
 * -29 -8
 * 3 -8
 * -15  2
 * 25 25
 * 20 -5
 * Input 2:-
 * A = -17 -2
 * 20 10
 * <p>
 * <p>
 * Example Output
 * Output 1:-
 * 65
 * Output 2:-
 * 30
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:-
 * The submatrix
 * 25 25
 * 20 -5
 * has the highest submatrix sum 65.
 * Explanation 2:-
 * The submatrix
 * 20 10
 * has the highest sub matrix sum 30.
 */
public class MaximumSumSubmatrix {
    /**
     * Approach: Kadane's Algorithm.
     */
    public int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[] tempCol = null;
        int maxSum = Integer.MIN_VALUE;

        for (int L = 0; L < M; L++) {
            tempCol = new int[N];
            for (int R = L; R < M; R++) {
                for (int i = 0; i < N; i++) {
                    tempCol[i] = tempCol[i] + A[i][R];
                }
                maxSum = Math.max(maxSum, maxSumSubarray(tempCol));
            }
        }
        return maxSum;
    }

    private int maxSumSubarray(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum > maxSum) maxSum = sum;
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }
}
