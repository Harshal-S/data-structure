package interviewbit.greedy.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOfAllSubmatricesTest {
    @Test
    public void testSumOfAllSubmatrices() {
        Assertions.assertEquals(40, new SumOfAllSubmatrices().solve(new int[][]{{2,3}, {2,3}}));
    }
}
