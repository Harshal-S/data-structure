package leetcode.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link ThreeSumClosest} solution
 */
public class ThreeSumClosestTest {
    @Test
    public void testThreeSumClosest() {
        Assertions.assertEquals(2, new ThreeSumClosest().solve(new int[]{-1,2,1,-4}, 1));
    }
}
