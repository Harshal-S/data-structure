package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumSumSubmatrixTest {
    @Test
    public void testMaximumSumSubmatrix() {
        int[][] A = new int[][]{{6, -5, -7, 4, -4}, {-9, 3, -6, 5, 2}, {-10, 4, 7, -6, 3}, {-8, 9, -3, 3, -7}};
        Assertions.assertEquals(17, new MaximumSumSubmatrix().solve(A));
    }
}
