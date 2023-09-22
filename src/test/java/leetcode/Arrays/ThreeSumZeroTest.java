package leetcode.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;

/**
 * {@link ThreeSumZero } solution
 */
public class ThreeSumZeroTest {

    Set<List<Integer>> expList;

    @BeforeEach
    public void setUp() {
        expList = new HashSet<>();
        expList.add(Arrays.asList(-1, -1, 2));
        expList.add(Arrays.asList(-1, 0, 1));
    }

    @Test
    public void testThreeSumZero() {
        List<List<Integer>> actList = new ThreeSumZero().solveWithoutSet(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> triplet : actList) {
            Assertions.assertTrue(expList.contains(triplet));
            Assertions.assertEquals(0, triplet.stream().reduce(0, Integer::sum));
        }
    }
}
