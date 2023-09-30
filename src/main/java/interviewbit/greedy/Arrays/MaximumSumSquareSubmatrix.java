package interviewbit.greedy.Arrays;

/**
 * Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1,
 * such that the sum of all the elements in the submatrix is maximum.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 103.
 * <p>
 * 1 <= B <= N
 * <p>
 * -102 <= A[i][j] <= 102.
 * <p>
 * <p>
 * <p>
 * Input Format
 * First arguement is an 2D integer matrix A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a single integer denoting the maximum sum of submatrix of size B x B.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [
 * [1, 1, 1, 1, 1]
 * [2, 2, 2, 2, 2]
 * [3, 8, 6, 7, 3]
 * [4, 4, 4, 4, 4]
 * [5, 5, 5, 5, 5]
 * ]
 * B = 3
 * Input 2:
 * <p>
 * A = [
 * [2, 2]
 * [2, 2]
 * ]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 48
 * Output 2:
 * <p>
 * 8
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Maximum sum 3 x 3 matrix is
 * 8 6 7
 * 4 4 4
 * 5 5 5
 * Sum = 48
 * Explanation 2:
 * <p>
 * Maximum sum 2 x 2 matrix is
 * 2 2
 * 2 2
 * Sum = 8
 */
public class MaximumSumSquareSubmatrix {
    public int solve(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;
        int maxSum = Integer.MIN_VALUE;

        int[][] prefixSum = new int[N][M];
        prefixSum[0][0] = A[0][0];

        for (int i = 1; i < N; i++) prefixSum[i][0] = prefixSum[i - 1][0] + A[i][0];
        for (int j = 1; j < M; j++) prefixSum[0][j] = prefixSum[0][j - 1] + A[0][j];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                prefixSum[i][j] = A[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        for (int T = 0; T <= N - B; T++) {
            for (int L = 0; L <= M - B; L++) {
                int Bo = T + B - 1;
                int R = L + B - 1;
                int sum = prefixSum[Bo][R];

                if (T > 0) sum = sum - prefixSum[T - 1][R];
                if (L > 0) sum = sum - prefixSum[Bo][L - 1];
                if (T > 0 && L > 0) sum = sum + prefixSum[T - 1][L - 1];

                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    public int solveWithPrefixSum2(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;
        int maxSum = Integer.MIN_VALUE;
        int prefixSum[][] = new int[N][M];

        //Rowwise prefix
        for (int i = 0; i < N; i++) {
            prefixSum[i][0] = A[i][0];
            for (int j = 1; j < M; j++) prefixSum[i][j] = prefixSum[i][j - 1] + A[i][j];
        }

        //columnwise prefix
        for (int j = 0; j < M; j++) {
            for (int i = 1; i < N; i++) prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j];
        }

        for (int T = 0; T <= N - B; T++) {
            for (int L = 0; L <= M - B; L++) {
                int Bo = T + B - 1;
                int R = L + B - 1;
                int sum = prefixSum[Bo][R];

                if (T > 0) sum = sum - prefixSum[T - 1][R];
                if (L > 0) sum = sum - prefixSum[Bo][L - 1];
                if (T > 0 && L > 0) sum = sum + prefixSum[T - 1][L - 1];

                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}
