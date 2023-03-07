public class ReverseInteger {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(s.reverse(2323232));
        System.out.println(-2147483648 * -1);
    }
}

class Solution {
    public int reverse(int x) {

        if (x == 0 || x == Integer.MIN_VALUE)
            return 0;

        StringBuilder sb = new StringBuilder();
        int inverter = 1;
        long returnValue;

        if (x < 0) {

            x *= inverter *= -1;
        }

        while (x != 0) {
            sb.append(x % 10);
            x /= 10;
        }

        returnValue = Long.parseLong(sb.toString());

        if (returnValue > Integer.MAX_VALUE)
            return 0;

        return (int) returnValue * inverter;
    }
}

class Solution2 {
    public int reverse(int x) {

        if (x == 0 || x == Integer.MIN_VALUE)
            return 0;

        int inverter = 1;
        long returnValue = 0;

        if (x < 0) {

            x *= inverter *= -1;
        }

        while (x != 0) {
            returnValue = (returnValue * 10) + (x % 10);
            x /= 10;
        }

        if (returnValue > Integer.MAX_VALUE)
            return 0;

        return (int) returnValue * inverter;
    }
}