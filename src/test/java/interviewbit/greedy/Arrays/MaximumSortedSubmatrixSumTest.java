package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumSortedSubmatrixSumTest {
    @Test
    public void testMaximumSubmatrixSum() {
        Assertions.assertEquals(228, new MaximumSortedSubmatrixSum().solve(new int[][]{{-83, -73, -70, -61}, {-56, -48, -13, 4}, {38, 48, 71, 71}}));
    }
}
