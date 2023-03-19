public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello", "ll"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (isValid(haystack, needle, i + 1, 1))
                    return i;
            }
        }
        return -1;
    }

    public boolean isValid(String haystack, String needle, int i, int count) {
        if (needle.length() == count)
            return true;

        if (haystack.length() == i || haystack.charAt(i) != needle.charAt(count))
            return false;

        return isValid(haystack, needle, i + 1, count + 1);
    }
}