package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContinuosSumQueryTest {
    @Test
    public void testContinuosSumQuery() {
        int[] expRes = new int[]{10, 55, 45, 25, 25};
        int[] actRes = new ContinuosSumQuery().solve(5, new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}});
        Assertions.assertArrayEquals(expRes, actRes);
    }
}
