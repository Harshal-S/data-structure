package interviewbit.greedy.Arrays;

/**
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query,
 * find and return the submatrix sum.
 * <p>
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 * <p>
 * NOTE:
 * <p>
 * Rows are numbered from top to bottom, and columns are numbered from left to right.
 * The sum may be large, so return the answer mod 10^9 + 7.
 * Also, select the data type carefully, if you want to store the addition of some elements.
 * Indexing given in B, C, D, and E arrays is 1-based.
 * Top Left 0-based index = (B[i] - 1, C[i] - 1)
 * Bottom Right 0-based index = (D[i] - 1, E[i] - 1)
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * 1 <= Q <= 100000
 * 1 <= B[i] <= D[i] <= N
 * 1 <= C[i] <= E[i] <= M
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer array B.
 * The third argument given is the integer array C.
 * The fourth argument given is the integer array D.
 * The fifth argument given is the integer array E.
 * (B[i], C[i]) represents the top left corner of the i'th query.
 * (D[i], E[i]) represents the bottom right corner of the i'th query.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array containing the submatrix sum for each query.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [   [1, 2, 3]
 * [4, 5, 6]
 * [7, 8, 9]   ]
 * B = [1, 2]
 * C = [1, 2]
 * D = [2, 3]
 * E = [2, 3]
 * Input 2:
 * <p>
 * A = [   [5, 17, 100, 11]
 * [0, 0,  2,   8]    ]
 * B = [1, 1]
 * C = [1, 4]
 * D = [2, 2]
 * E = [2, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [12, 28]
 * Output 2:
 * <p>
 * [22, 19]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 * For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
 * Explanation 2:
 * <p>
 * For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 * For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 */
public class SubmatrixSumQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int N = A.length;
        int M = A[0].length;
        long[][] prefixSumMatrix = new long[N][M];
        int Q = B.length;
        int mod = 1000000007;
        int[] submatrixSum = new int[Q];

        prefixSumMatrix[0][0] = A[0][0];
        for (int i = 1; i < N; i++) {
            prefixSumMatrix[i][0] = A[i][0] + prefixSumMatrix[i - 1][0];
        }
        for (int i = 1; i < M; i++) {
            prefixSumMatrix[0][i] = A[0][i] + prefixSumMatrix[0][i - 1];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                prefixSumMatrix[i][j] = A[i][j] + prefixSumMatrix[i - 1][j] + prefixSumMatrix[i][j - 1] - prefixSumMatrix[i - 1][j - 1];
            }
        }

        for (int i = 0; i < Q; i++) {
            int A1 = B[i] - 1;
            int B1 = C[i] - 1;
            int A2 = D[i] - 1;
            int B2 = E[i] - 1;

            long sum = prefixSumMatrix[A2][B2];

            if (B1 > 0) sum = sum - prefixSumMatrix[A2][B1 - 1];
            if (A1 > 0) sum = sum - prefixSumMatrix[A1 - 1][B2];
            if (A1 > 0 && B1 > 0) sum = sum + prefixSumMatrix[A1 - 1][B1 - 1];

            if (sum % mod < 0)
                submatrixSum[i] = (int) ((sum % mod + mod) % mod);
            else submatrixSum[i] = (int) sum % mod;
        }
        return submatrixSum;
    }
}
