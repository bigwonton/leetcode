package L0873LengthofLongestFibonacciSubsequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 3 无重复字符的最长子串
public class lengthOfLongestSubstring {
    // 暴力法，会超时，时间复杂度O(n^3)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int i, int j) {
        Set<Character> sets = new HashSet<Character>();
        for (int k = i; k < j; k++) {
            Character ch = s.charAt(k);
            if (sets.contains(ch)) {
                return false;
            }
            sets.add(ch);
        }
        return true;
    }

    // 滑动窗口法 时间复杂度O(2n) = O(n)
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // 优化的滑动窗口 O(n)
    public int lengthOfLongestSubstring3 (String s) {
        int n = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j+1);
            ans = Math.max(ans, j -i + 1);
        }
        return ans;
    }
}
