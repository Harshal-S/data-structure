package leetcode.String;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParenthesis {
    public boolean solve(String s) {
        Stack<Character> parenthesisStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                parenthesisStack.push(ch);
            } else {
                if (parenthesisStack.isEmpty()) return false;
                char chInStack = parenthesisStack.pop();
                if (chInStack == '(') {
                    if (ch != ')')
                        return false;
                } else if (chInStack == '[') {
                    if (ch != ']')
                        return false;
                } else if (chInStack == '{') {
                    if (ch != '}')
                        return false;
                }
            }

        }
        return parenthesisStack.isEmpty();
    }
}
