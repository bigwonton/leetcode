package L0012IntegerToRoman;

public class Solution {
    public String intToRoman(int num) {
        String res = "";
        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] values= {1000, 500, 100, 50, 10, 5, 1};

        for (int i = 0; i < roman.length; i+=2) {
            int x = num / values[i];
            if (x < 4) {
                for (int j = 0; j < x; j++) {
                    res += roman[i];
                }
            } else if (x == 4) {
                res = res + roman[i] + roman[i - 1];
            } else if ( x > 4 && x < 9) {
                res = res + roman[i - 1];
                for (int k = 5; k < x; k++) {
                    res += roman[i];
                }
            } else if (x == 9) {
                res = res + roman[i] + roman[i - 2];
            }
            num %= values[i];
        }
        return res;
    }
}
