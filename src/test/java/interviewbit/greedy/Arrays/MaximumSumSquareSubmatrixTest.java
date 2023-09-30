package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumSumSquareSubmatrixTest {
    @Test
    public void testMaximumSumSquareSubmatrix() {
        int[][] A = new int[][]{{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 8, 6, 7, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}};
        Assertions.assertEquals(48, new MaximumSumSquareSubmatrix().solve(A, 3));
    }
}
