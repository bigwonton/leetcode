package L0003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> chs = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (left < length && right < length) {
            Character ch = s.charAt(right);
            if (!chs.contains(ch)) {
                chs.add(ch);
                right++;
                res = Math.max(res, right - left);
            } else {
                chs.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        s = "abcabcbb";
        new Solution().lengthOfLongestSubstring(s);
    }
}
