public class RomanToInteger {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.romanToInt("MCMXCIV"));
    }
}

// Recursive
class Solution {

    public int getArabicEqu(char r) {
        if (r == 'I')
            return 1;

        if (r == 'V')
            return 5;

        if (r == 'X')
            return 10;

        if (r == 'L')
            return 50;

        if (r == 'C')
            return 100;

        if (r == 'D')
            return 500;

        if (r == 'M')
            return 1000;

        return -1;
    }

    public int romanToInt(String s, int stringPos, int count) {
        if (stringPos < 0)
            return count;

        if (stringPos != s.length() - 1 && getArabicEqu(s.charAt(stringPos)) < getArabicEqu(s.charAt(stringPos + 1)))
            count -= getArabicEqu(s.charAt(stringPos));
        else
            count += getArabicEqu(s.charAt(stringPos));

        return romanToInt(s, --stringPos, count);
    }

    public int romanToInt(String s) {
        return romanToInt(s, s.length() - 1, 0);
    }
}