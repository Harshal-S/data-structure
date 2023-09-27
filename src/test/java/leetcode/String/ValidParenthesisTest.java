package leetcode.String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidParenthesisTest {
    @Test
    public void testValidParenthesis() {
        Assertions.assertEquals(true, new ValidParenthesis().solve("()[]{}"));
    }
}
