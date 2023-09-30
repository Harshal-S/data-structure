package interviewbit.greedy.Arrays;

/**
 * https://www.interviewbit.com/problems/rain-water-trapped/
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * Input Format
 * First and only argument is the vector A
 * <p>
 * Output Format
 * Return one integer, the answer to the question
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [0, 1, 0, 2]
 * Input 2:
 * <p>
 * A = [1, 2]
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 1 unit is trapped on top of the 3rd element.
 * Explanation 2:
 * <p>
 * No water is trapped.
 * <p>
 * IMAGE: src/main/java/resources/RainWaterTrapped.PNG
 */

public class RainWaterTrapped {
    /**
     * Approacch: Prefix sum to find left max and right max
     */
    public int solveUsingPrefixSum(final int[] A) {
        int[] leftMaxHeight = new int[A.length];
        int[] rightMaxHeight = new int[A.length];
        int totalWaterTrapped = 0;
        for (int i = 1; i < A.length; i++) {
            leftMaxHeight[i] = Math.max(A[i - 1], leftMaxHeight[i - 1]);
        }

        for (int i = A.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(A[i + 1], rightMaxHeight[i + 1]);
        }

        for (int i = 1; i < A.length - 1; i++) {
            int max = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if (A[i] < max) {
                totalWaterTrapped += max - A[i];
            }
        }

        return totalWaterTrapped;
    }

    public int solveUsingTwoPointers() {
        // TODO
        return 0;
    }
}
