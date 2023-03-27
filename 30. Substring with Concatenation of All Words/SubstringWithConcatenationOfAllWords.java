import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.findSubstring(
                "barfoofoobarthefoobarman",
                new String[] { "bar", "foo", "the" }));
        System.out
                .println(s.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
        System.out
                .println(s.findSubstring("bcabbcaabbccacacbabccacaababcbb",
                        new String[] { "c", "b", "a", "c", "a", "a", "a", "b", "c" }));
    }
}

// Without sliding window
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> returnList = new ArrayList<>();
        int matchLength = words.length * words[0].length();
        Map<String, Integer> allWords = new HashMap<>();

        for (int i = 0; i < words.length; i++)
            allWords.put(words[i], allWords.getOrDefault(words[i], 0) + 1);

        for (int i = 0; i <= s.length() - matchLength; i++) {
            if (matchSubstring(s, words, i, allWords))
                returnList.add(i);
        }
        return returnList;
    }

    private boolean matchSubstring(String s, String[] words, int stringPos, Map<String, Integer> allWords) {

        Map<String, Integer> usedWords = new HashMap<>(allWords);
        int matchLength = words.length * words[0].length();

        for (int i = stringPos; i < stringPos + matchLength; i += words[0].length()) {
            Integer stringInMap = usedWords.get(s.substring(i, i + words[0].length()));

            if (stringInMap == null || stringInMap == 0)
                return false;

            usedWords.put(s.substring(i, i + words[0].length()), stringInMap - 1);
        }
        return true;
    }
}

// With sliding window
class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> returnList = new ArrayList<>();
        Map<String, Integer> allWords = new HashMap<>();

        for (int i = 0; i < words.length; i++)
            allWords.put(words[i], allWords.getOrDefault(words[i], 0) + 1);

        for (int i = 0; i < words[0].length(); i++) {
            matchAndAddSubstring(s, words, i, allWords, returnList);
        }
        return returnList;
    }

    private void matchAndAddSubstring(String s, String[] words, int stringPos, Map<String, Integer> allWords,
            List<Integer> returnList) {

        Map<String, Integer> usedWords = new HashMap<>();
        int matchLength = words.length * words[0].length();

        for (int leftPointer = stringPos,
                rightPointer = leftPointer + words[0].length(); s.length()
                        - leftPointer >= matchLength; rightPointer += words[0].length()) {

            String currentString = s.substring(rightPointer - words[0].length(), rightPointer);

            if (allWords.get(currentString) == null) {
                leftPointer = rightPointer;
                usedWords.clear();
                continue;
            }

            usedWords.put(currentString, usedWords.getOrDefault(currentString, 0) + 1);

            if (usedWords.get(currentString) > allWords.get(currentString)) {

                while (usedWords.get(currentString) > allWords.get(currentString)) {

                    String leftPointerString = s.substring(leftPointer, leftPointer +
                            words[0].length());

                    usedWords.put(leftPointerString, usedWords.get(leftPointerString) - 1);
                    leftPointer += words[0].length();
                }
            }
            if (rightPointer - leftPointer == matchLength) {
                returnList.add(leftPointer);
                String leftPointerString = s.substring(leftPointer, leftPointer +
                        words[0].length());
                usedWords.put(leftPointerString, usedWords.get(leftPointerString) - 1);
                leftPointer += words[0].length();
            }
        }
    }
}