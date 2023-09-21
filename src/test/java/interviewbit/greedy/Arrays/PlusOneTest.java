package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PlusOneTest {
    @Test
    public void testPlusOne() {

        Assertions.assertArrayEquals(new int[]{1, 2, 4}, new PlusOne().plusOne(new int[]{1, 2, 3}));
        Assertions.assertArrayEquals(new int[]{1, 3, 0}, new PlusOne().plusOne(new int[]{1, 2, 9}));
        Assertions.assertArrayEquals(new int[]{1, 0, 0, 0}, new PlusOne().plusOne(new int[]{9, 9, 9}));
    }
}
