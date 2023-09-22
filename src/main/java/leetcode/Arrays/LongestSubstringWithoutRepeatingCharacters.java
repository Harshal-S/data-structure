package leetcode.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">...</a>
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int solveBruteForce(String s) {
        int iMax = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> characterSet = new HashSet<Character>();
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if (characterSet.contains(s.charAt(j))) {
                    break;
                }
                characterSet.add(s.charAt(j));
                count++;
            }
            if (iMax < count) iMax = count;
        }
        return iMax;
    }

    public int solveOptimizedUsingHashMap(String A) {
        int maxLen = 0;
        int s, e = s = 0;
        Map<Character, Integer> hmap = new HashMap<>();
        while (e < A.length()) {
            char ch = A.charAt(e);
            if (hmap.containsKey(ch)) {
                if (maxLen < e - s) maxLen = e - s;
                if (s <= hmap.get(ch)) s = hmap.get(ch) + 1;
            }
            hmap.put(ch, e);
            e++;
        }
        if (maxLen < e - s) maxLen = e - s;
        return maxLen;
    }

    public int solveOptimizedUsingArray(String A) {
        int maxLen = 0;
        int sIndx, eIndx = sIndx = 0;
        int charArr[] = new int[256];
        while (eIndx < A.length()) {
            char ch = A.charAt(eIndx);
            if (charArr[ch] != 0) {
                if (maxLen < eIndx - sIndx) maxLen = eIndx - sIndx;
                if (sIndx <= charArr[ch] - 1) sIndx = charArr[ch];  // check if repeating charater is ahead of starting index.
                                                                    // i.e current repeating charater is inside the current substring
            }
            charArr[ch] = eIndx + 1;    // we are storing the position of character in charArr.
            eIndx++;
        }
        if (maxLen < eIndx - sIndx) maxLen = eIndx - sIndx;
        return maxLen;
    }
}
