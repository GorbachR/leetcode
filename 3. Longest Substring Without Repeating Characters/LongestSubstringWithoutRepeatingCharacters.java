import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {

        List<Character> memo = new ArrayList<>();
        int currentCount = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {

            char charAt = s.charAt(i);

            if(memo.contains(charAt)) {
                memo.subList(0, memo.indexOf(charAt) + 1).clear();
                currentCount = memo.size();
            }

            // if(memo.contains(charAt)) {
            //     memo = memo.subList(memo.indexOf(charAt) + 1, memo.size());
            //     currentCount = memo.size();
            // }

            currentCount++;
            memo.add(s.charAt(i));

            maxCount = currentCount > maxCount ? currentCount : maxCount;
        }

        return maxCount;
    }
}