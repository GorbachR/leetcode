
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("eabcbbcb"));
    }
}

class Solution {
    public String longestPalindrome(String s) {

        int positionLength = 2 * s.length() + 1;
        char[] stringChars = new char[positionLength];
        int[] palindromeLength = new int[positionLength];
        int longestPalindromeCenter = 0, longestPalindromeLength = 0;
        
        for (int i = 0; i < positionLength; i++) {
            if(i % 2 == 0) stringChars[i] = '|';
            else { 
                stringChars[i] = s.charAt((i - 1) / 2);
                palindromeLength[i] = 1;
            }
        }

        for (int i = 0, alreadyCheckedCount = 0; i < positionLength; i++) {

            if(alreadyCheckedCount != 0) {
                alreadyCheckedCount--;
                continue;
            }

            boolean isPalindrome = true;

            if(i != 0 && palindromeLength[i - 1] > 1) {

                int centerPos = i - 1;
                int centerRightPos = centerPos + palindromeLength[i - 2];
                int currentLeftPos = 2 * (centerPos) - i;

                if(palindromeLength[currentLeftPos] < centerRightPos - i 
                   || currentLeftPos == centerRightPos - i && centerRightPos == 2 * s.length()) {
                    alreadyCheckedCount  =  palindromeLength[centerPos];
                }

                for(int j = 1; j <= palindromeLength[centerPos]; j++) {
                if(centerPos + 1 > palindromeLength[centerPos]) break;
                palindromeLength[centerPos + j] = palindromeLength[centerPos - j];
                }
            }

            while(isPalindrome) {

                if(i - palindromeLength[i] - 1 < 0 || 
                i + palindromeLength[i] + 1 >= positionLength) break;

                if(stringChars[i - palindromeLength[i] - 1] 
                == stringChars[i + palindromeLength[i] + 1]) {
                    palindromeLength[i]++;
                } else {
                    isPalindrome = false;
                }
                    
            }

            if(palindromeLength[i] > longestPalindromeLength) {
                longestPalindromeLength = palindromeLength[i];
                longestPalindromeCenter = i;
            }
        }

        char[] returnData = new char[longestPalindromeLength];
        int startPosition = longestPalindromeCenter - longestPalindromeLength + 1;

        for(int i = startPosition, counter = 0;
            counter < longestPalindromeLength; i += 2, counter++) 
        returnData[counter] = stringChars[i];
        
        return new String(returnData);
    }
}