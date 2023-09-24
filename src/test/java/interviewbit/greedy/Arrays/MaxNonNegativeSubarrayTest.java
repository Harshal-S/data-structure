package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxNonNegativeSubarrayTest {

    @Test
    public void testMaxNonNegativeSubarray() {
        int[] res = new MaxNonNegativeSubarray().solve(new int[]{1,2,3,-6,2,3,0});
        int[] actRes = new int[]{1,2,3};
        for(int i=0;i<res.length;i++) {
            Assertions.assertEquals(actRes[i], res[i]);
        }
    }
}
