package interviewbit.greedy.Arrays;

/**
 * Given a row-wise and column-wise sorted matrix A of size N * M.
 * Return the maximum non-empty submatrix sum of this matrix.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -109 <= A[i][j] <= 109
 * <p>
 * <p>
 * Input Format
 * The first argument is a 2D integer array A.
 * <p>
 * <p>
 * Output Format
 * Return a single integer that is the maximum non-empty submatrix sum of this matrix.
 * <p>
 * <p>
 * Example Input
 * Input 1:-
 * -5 -4 -3
 * A = -1  2  3
 * 2  2  4
 * Input 2:-
 * 1 2 3
 * A = 4 5 6
 * 7 8 9
 * <p>
 * <p>
 * Example Output
 * Output 1:-
 * 12
 * Output 2:-
 * 45
 * <p>
 * <p>
 * Example Explanation
 * Expanation 1:-
 * The submatrix with max sum is
 * -1 2 3
 * 2 2 4
 * Sum is 12.
 * Explanation 2:-
 * The largest submatrix with max sum is
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * The sum is 45.
 */
public class MaximumSortedSubmatrixSum {
    /**
     * {@link SubmatrixSumQueries}
     * Approach :Prefix sum of matrix in reverse order
     *
     */
    public long solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        long maxSum = Long.MIN_VALUE;
        long[][] prefixSum = new long[N][M];

        for (int i = 0; i < N; i++) {
            prefixSum[i][M - 1] = A[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                prefixSum[i][j] = prefixSum[i][j + 1] + A[i][j];
            }
        }

        for (int j = 0; j < M; j++) {
            for (int i = N - 2; i >= 0; i--) {
                prefixSum[i][j] = prefixSum[i + 1][j] + prefixSum[i][j];
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (prefixSum[i][j] > maxSum)
                    maxSum = prefixSum[i][j];
            }
        }
        return maxSum;
    }
}
