import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.generateParenthesis(3));
    }
}

// Catalan Numbers?
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> allSequences = new ArrayList<>();
        generateCombinations(n, 0, new char[n * 2], 0, allSequences);
        return allSequences;
    }

    private void generateCombinations(int n, int bracketCount, char[] currentString, int stringPos,
            List<String> sequences) {
        if (stringPos == currentString.length) {
            if (bracketCount == 0)
                sequences.add(new String(currentString));
            return;
        }

        if (bracketCount < 0 || bracketCount > (n * 2) / 2)
            return;

        currentString[stringPos] = '(';
        generateCombinations(n, bracketCount + 1, currentString, stringPos + 1, sequences);
        currentString[stringPos] = ')';
        generateCombinations(n, bracketCount - 1, currentString, stringPos + 1, sequences);
    }
}