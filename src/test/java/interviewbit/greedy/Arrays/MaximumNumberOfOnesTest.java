package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumNumberOfOnesTest {
    @Test
    public void testMaximumNumberOfOnes() {
        Assertions.assertEquals(2, new MaximumNumberOfOnes().optimizedSolution(new int[][]{{0,0,0,1,1,1}, {0,0,0,0,1,1},{0,0,1,1,1,1}, {0,0,0,0,1,1}}));
    }
}
