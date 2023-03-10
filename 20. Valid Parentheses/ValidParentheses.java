import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()[]{}"));
    }
}

class Solution {
    Map<Character, Character> bracketMapping = new HashMap<>();

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            Character currenChar = s.charAt(index);

            if (stack.empty() && bracketMapping.get(currenChar) != null)
                return false;

            if (bracketMapping.get(currenChar) == null)
                stack.add(currenChar);

            else if (bracketMapping.get(currenChar) == stack.peek())
                stack.pop();
            else
                return false;

        }

        return stack.empty() ? true : false;
    }

    public Solution() {
        this.bracketMapping = Map.of('}', '{', ')', '(', ']', '[');
    }
}