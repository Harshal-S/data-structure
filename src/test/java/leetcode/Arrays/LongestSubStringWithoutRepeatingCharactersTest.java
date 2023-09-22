package leetcode.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link LongestSubstringWithoutRepeatingCharacters} solution
 */
public class LongestSubStringWithoutRepeatingCharactersTest {
    @Test
    public void testLongestSubstringWithoutRepeatingCharacters() {
        Assertions.assertEquals(3, new LongestSubstringWithoutRepeatingCharacters().solveOptimizedUsingArray("abcabcbb"));
    }
}
