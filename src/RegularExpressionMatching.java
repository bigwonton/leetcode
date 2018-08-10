public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // p的长度为0，说明匹配结束，若s也未空，匹配成功，否则失败
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // 若p的长度为1，那么就匹配单个字符。
        // 若p的长度不为1，且第二个字符不为*，那么就匹配单个字符，然后分别去掉s和p的首字符，继续匹配。
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
        // p的首字符和s的首字符匹配上了，但也不知道这个*前面的字符重复多少次（可能为0~任意数），于是，用s匹配 刚刚匹配上的p的首字符和第二个字符*
        // 如果去掉这一部分，后面匹配上了，说明这个*前面的字符重复0次
        // 如果没匹配上，那就去掉s的首字符，再重试，如果有一次匹配上了，此时就整体匹配上了。递归结束的条件是——s的首字符和p的首字符匹配失败。
        while (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
              if (isMatch(s, p.substring(2))) {
                  return true;
              }
              s = s.substring(1);
        }
        // p的首字符和s的首字符没有匹配上，去掉p的首字符和第二个字符*，再匹配
        return isMatch(s, p.substring(2));
    }
}
