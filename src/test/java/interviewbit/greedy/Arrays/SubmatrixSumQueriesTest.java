package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubmatrixSumQueriesTest {
    @Test
    public void testSubmatrixSumQueries() {
        Assertions.assertArrayEquals(new int[]{22, 19}, new SubmatrixSumQueries().solve(new int[][]{{5, 17, 100, 11}, {0, 0, 2, 8}}, new int[]{1, 1}, new int[]{1, 4}, new int[]{2, 2}, new int[]{2, 4}));
    }
}
