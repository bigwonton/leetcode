import java.util.Arrays;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] charArr = manacherString(s);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        int center = -1;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
           if (pArr[i] > max) {
               max = pArr[i];
               center = i;
               System.out.println("center="+center);
               System.out.println("max="+(max -1));
           }

        }
//        return Arrays.toString(charArr).substring(center - (max-1), center + max);
        return Arrays.toString(charArr).replaceAll(",","").replaceAll(" ","")
                .replaceAll("\\[","").replaceAll("\\]","")
                .substring(center - (max -1), center + max).replaceAll("#","");
    }

    public static char[] manacherString(String s) {
        char[] charArr = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "bb";
        LongestPalindrome test = new LongestPalindrome();
        System.out.println(test.longestPalindrome(str1));
    }
}
