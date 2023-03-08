import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.isMatch("aa", "a*a"));
    }
}

// First version
class Solution {
    public boolean isMatch(String s, String p, int sId, int pId) {

        boolean isMatch = false;

        if (pId >= p.length())
            return sId >= s.length() ? true : false;

        if (sId < s.length()) {
            if (s.charAt(sId) == p.charAt(pId) || p.charAt(pId) == '.')
                isMatch = true;
        }

        if (pId == p.length() - 1 || p.charAt(pId + 1) != '*')
            return isMatch ? isMatch(s, p, sId + 1, pId + 1) : false;

        return isMatch && isMatch(s, p, sId + 1, pId) || isMatch(s, p, sId, pId + 2);
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }
}

// Memoized Version
class Solution2 {
    public boolean isMatch(String s, String p, int sId, int pId,
            Map<List<Integer>, Boolean> memo) {

        if (memo.get(Arrays.asList(sId, pId)) != null)
            return memo.get(Arrays.asList(sId, pId));

        if (pId >= p.length())
            return sId >= s.length();

        boolean isMatch = false;

        if (sId < s.length())
            if (s.charAt(sId) == p.charAt(pId) || p.charAt(pId) == '.')
                isMatch = true;

        if (pId == p.length() - 1 || p.charAt(pId + 1) != '*') {
            memo.put(Arrays.asList(sId, pId), isMatch ? isMatch(s, p, sId + 1, pId + 1,
                    memo) : false);
            return memo.get(Arrays.asList(sId, pId));
        }
        memo.put(Arrays.asList(sId, pId),
                isMatch && isMatch(s, p, sId + 1, pId, memo) || isMatch(s, p, sId, pId + 2,
                        memo));
        return memo.get(Arrays.asList(sId, pId));
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0, new HashMap<>());
    }
}