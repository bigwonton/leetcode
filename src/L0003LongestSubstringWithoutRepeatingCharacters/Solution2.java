package L0003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
       int left = 0, right = 0;
       Map<Character, Integer> map = new HashMap<>();
       int res = 0;
       while (left < s.length() && right < s.length()) {
           char ch = s.charAt(right);
           if (map.containsKey(ch)) {
               left = Math.max(left, map.get(ch) + 1);
           }
           map.put(ch, right);
           res = Math.max(res, right - left + 1);
           right++;
       }
       return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
//        s = "abcabcbb";
        new Solution2().lengthOfLongestSubstring(s);
    }
}