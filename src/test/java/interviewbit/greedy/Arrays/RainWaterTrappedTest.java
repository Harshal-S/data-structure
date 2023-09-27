package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RainWaterTrappedTest {
    @Test
    public void testRainWaterTrapped() {
        Assertions.assertEquals(6, new RainWaterTrapped().solveUsingPrefixSum(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
