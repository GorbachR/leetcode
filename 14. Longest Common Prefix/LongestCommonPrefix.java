
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }
}

// Only beats 5% memory wise?
class Solution {

    public String longestCommonPrefix(String[] strs, int arrayPos, int stringPos) {

        if (arrayPos == strs.length)
            return longestCommonPrefix(strs, 0, stringPos + 1);

        if (strs[arrayPos].length() == stringPos ||
                strs[arrayPos].charAt(stringPos) != strs[0].charAt(stringPos))
            return strs[arrayPos].substring(0, stringPos);

        return longestCommonPrefix(strs, arrayPos + 1, stringPos);
    }

    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix(strs, 0, 0);
    }
}