
public class StringtoInteger {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("2147483648"));

    }
}

class Solution {
    public int myAtoi(String s) {

        int sLength = s.length();
        int result = 0;
        int startIndex = 0;
        int inverter = 1;

        if (sLength == 0)
            return 0;
        else if (sLength == 1) {
            return isDigit(s.charAt(0)) ? s.charAt(0) - 48 : 0;
        }

        for (int i = 0; i < sLength; i++) {
            if (s.charAt(i) == 0x20)
                continue;

            startIndex = i;
            break;
        }

        if (s.charAt(startIndex) == 0x2D) {
            inverter *= -1;
            startIndex++;
        } else if (s.charAt(startIndex) == 0x2B)
            startIndex++;

        for (int i = startIndex; i < sLength; i++) {
            char currentChar = s.charAt(i);
            if (!isDigit(currentChar))
                break;
            try {
                result = Math.addExact(Math.multiplyExact(result, 10), (currentChar - 48));
            } catch (Exception e) {
                return inverter == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return result * inverter;
    }

    boolean isDigit(char c) {
        return 0x30 <= c && c <= 0x39;
    }
}