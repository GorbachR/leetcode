public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("(()"));
    }
}

class Solution {
    public int longestValidParentheses(String s) {

        int subStringLength = 0;

        for (int i = 0, opening = 0,
                closing = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                opening++;
            else
                closing++;

            if (opening == closing) {
                int length = opening * 2;
                if (length > subStringLength)
                    subStringLength = length;
            }

            if (closing > opening)
                opening = closing = 0;
        }

        for (int i = s.length() - 1, opening = 0, closing = 0; i >= 0; i--) {

            if (s.charAt(i) == '(')
                opening++;
            else
                closing++;

            if (opening == closing) {
                int length = opening * 2;
                if (length > subStringLength)
                    subStringLength = length;
            }

            if (opening > closing)
                closing = opening = 0;
        }

        return subStringLength;
    }
}