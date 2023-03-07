public class PalindromeNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(121));
    }
}

class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        int reversedInt = 0;

        for (int i = x; i != 0; i /= 10) {
            reversedInt = (reversedInt * 10) + (i % 10);
        }

        return x == reversedInt ? true : false;
    }
}