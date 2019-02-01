package L0005LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        // 边界判断不要忘记
        if (s == null || s.length() == 0) return "";

        int left = 0, right = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i ++) {
            int len1 = expendAroundCenter(s, i, i);
            int len2 = expendAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                left = i - (len - 1)/ 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int expendAroundCenter(String s, int left, int right) {
        while (left >=0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;

        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
