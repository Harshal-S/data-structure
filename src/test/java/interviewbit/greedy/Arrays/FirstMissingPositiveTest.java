package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstMissingPositiveTest {
    @Test
    public void testFindingMissingPositive(){
        FirstMissingPositive test = new FirstMissingPositive();
        Assertions.assertEquals(1, test.firstMissingPositive(new int[]{-1, 5, 3, 4 , 5}));
        Assertions.assertEquals(2, test.firstMissingPositive(new int[]{1, 5, 3, 4, 5}));
        Assertions.assertEquals(4, test.firstMissingPositive(new int[]{1, 5, 3, -4, 5, 2, 6}));
    }
}
