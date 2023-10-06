package interviewbit.greedy.Arrays;

/**
 * Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.
 * <p>
 * NOTE:
 * <p>
 * If two rows have the maximum number of 1 then return the row which has a lower index.
 * Rows are numbered from top to bottom and columns are numbered from left to right.
 * Assume 0-based indexing.
 * Assume each row to be sorted by values.
 * Expected time complexity is O(rows + columns).
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000
 * <p>
 * 0 <= A[i] <= 1
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the row with the maximum number of 1.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [   [0, 1, 1]
 * [0, 0, 1]
 * [0, 1, 1]   ]
 * Input 2:
 * <p>
 * A = [   [0, 0, 0, 0]
 * [0, 0, 0, 1]
 * [0, 0, 1, 1]
 * [0, 1, 1, 1]    ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Row 0 has maximum number of 1s.
 * Explanation 2:
 * <p>
 * Row 3 has maximum number of 1s.
 */
public class MaximumNumberOfOnes {
    public int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < M; row++) {
                if (A[row][col] == 1) return row;
            }
        }
        return 0;
    }

    public int optimizedSolution(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        int row = 0;
        int col = M - 1;
        int rowWithMaxOnes = 0;

        while (row < N && col >= 0) {
            if (A[row][col] == 1) {
                rowWithMaxOnes = row;
                col--;
            } else row++;
        }
        return rowWithMaxOnes;
    }
}
