package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlipTest {

    @Test
    public void testFlip() {
        int[] actRes = new Flip().solve("01010100111100");
        int[] expRes = new int[]{1, 8};

        Assertions.assertArrayEquals(expRes, actRes);
    }


}
