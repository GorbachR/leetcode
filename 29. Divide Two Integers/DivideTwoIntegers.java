public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(20, -4));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {

        boolean negative = false;

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if (dividend < 0) {
            dividend = ~dividend + 1;
            negative = !negative;
        }
        if (divisor < 0) {
            divisor = ~divisor + 1;
            negative = !negative;
        }

        int quotient = 0;

        while (dividend - divisor >= 0) {

            int count = 0;

            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }

            dividend -= divisor << count;
            quotient += 1 << count;
        }

        return negative ? ~quotient + 1 : quotient;
    }
}