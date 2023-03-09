import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.letterCombinations("23"));
    }
}

class Solution {
    String[] telStrings;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        return letterCombinations(digits, digits.length() - 1);
    }

    private List<String> letterCombinations(String digits, int pos) {
        if (pos == -1) {
            ArrayList<String> emptyList = new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }

        List<String> digitsWithoutFirst = letterCombinations(digits, pos - 1);
        List<String> digitsWithFirst = new ArrayList<>();

        String teleCharsString = telStrings[Integer.parseInt(digits.substring(pos, pos + 1)) - 2];

        for (int i = 0; i < digitsWithoutFirst.size(); i++) {
            for (int j = 0; j < teleCharsString.length(); j++) {
                digitsWithFirst.add(digitsWithoutFirst.get(i).concat(teleCharsString.substring(j, j + 1)));
            }
        }
        return digitsWithFirst;
    }

    public Solution() {
        this.telStrings = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    }
}