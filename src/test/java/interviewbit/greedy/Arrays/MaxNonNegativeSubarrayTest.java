package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubarrayTest {

    @Test
    public void testMaxNonNegativeSubarray() {
        int[] expRes = new MaxNonNegativeSubarray().solve(new int[]{1, 2, 3, -6, 2, 3, 0});
        int[] actRes = new int[]{1, 2, 3};
        Assertions.assertArrayEquals(expRes, actRes);
    }

    @Test
    public void testMaxNonNegativeSubarrayWithList() {
        ArrayList<Integer> actRes = new MaxNonNegativeSubarray().solveWithArrayList(new ArrayList<>(Arrays.asList(1, 2, 3, -6, 2, 3, 0)));
        ArrayList<Integer> expRes = new ArrayList<>(new ArrayList<>(Arrays.asList(1, 2, 3)));
        for (int i = 0; i < expRes.size(); i++) {
            Assertions.assertEquals(actRes.get(i), expRes.get(i));
        }
    }
}
