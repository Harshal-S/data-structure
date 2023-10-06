package interviewbit.greedy.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive
 * Given an unsorted integer array, A of size N. Find the first missing positive integer.
 * <p>
 * Note: Your algorithm should run in O(n) time and use constant space.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000000
 * <p>
 * -109 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the first missing positive integer.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * [1, 2, 0]
 * Input 2:
 * <p>
 * [3, 4, -1, 1]
 * Input 3:
 * <p>
 * [-8, -7, -6]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 * Output 3:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * A = [1, 2, 0]
 * First positive integer missing from the array is 3.
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int N = A.length;
        int i = 0;
        while (i < N) {
            // checking if element is inside the range i.e 1<=ele<=N
            // also checking if ele correct index has already the correct element present at that index or not.
            while (A[i] > 0 && A[i] < N + 1 && A[i] != i + 1 && A[A[i] - 1] != A[i]) {
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
            i++;
        }

        for (int j = 0; j < N; j++) {
            if (A[j] != j + 1) return j + 1;
        }
        return N + 1;
    }
}

