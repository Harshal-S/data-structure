package leetcode.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumTest {
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{0, 3}, new TwoSum().solve(new int[]{2, 11, 15, 7}, 9));
    }
}