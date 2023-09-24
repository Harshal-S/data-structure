package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubarrayTest {

    @Test
    public void testMaxNonNegativeSubarray() {
        int[] res = new MaxNonNegativeSubarray().solve(new int[]{1, 2, 3, -6, 2, 3, 0});
        int[] actRes = new int[]{1, 2, 3};
        for (int i = 0; i < res.length; i++) {
            Assertions.assertEquals(actRes[i], res[i]);
        }
    }

    @Test
    public void testMaxNonNegativeSubarrayWithList() {
        ArrayList<Integer> res = new MaxNonNegativeSubarray().solveWithArrayList(new ArrayList<>(Arrays.asList(1, 2, 3, -6, 2, 3, 0)));
        ArrayList<Integer> actRes = new ArrayList<>(new ArrayList<>(Arrays.asList(1, 2, 3)));
        for (int i = 0; i < res.size(); i++) {
            Assertions.assertEquals(actRes.get(i), res.get(i));
        }
    }
}
