package L0010RegularExpressionMatching;

public class Solution {
    // 对pattern进行分析
    public boolean isMatch(String s, String p) {
        // case 1. pattern长度为0
        if (p.length() == 0) {
            return s.length() == 0;
        }
        // case2 pattern 长度不为0
        // case2.1 string长度为0    false
        // case2.2 string长度不为0 匹配第一个字符
        // case2.2.1 无特殊字符，直接比较
        // case2.2.2 pattern第一个字符为.     true
        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //  case2.2.3 pattern长度大于1，且第2个字符为*
        // case2.2.3.1 *前面的字符匹配0次
        // case2.2.3.2 *前面的字符匹配大于0次
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }
        // 正常匹配，各自往后移一位
        else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
