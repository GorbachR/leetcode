import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.convert("PAYPALISHIRING", 4));
    }
}

// class Solution {
//     public String convert(String s, int numRows) {

//         if(numRows == 1) return s;

//         int stringLength = s.length();
//         String[] rows = new String[numRows];
//         boolean decrement = false;

//         for (int i = 0; i < rows.length; i++) {
//             rows[i] = "";
//         }

//         for (int i = 0, j = 0; i < stringLength; i++, j = decrement ? --j : ++j) {

//             rows[j] += s.charAt(i);
//             if(j == numRows - 1 || j == 0 && i != 0) decrement = !decrement;
//         }

//         String returnString = "";
        
//         for (int i = 0; i < rows.length; i++) {
//             returnString += rows[i];
            
//         }

//         return returnString;

//     }
// }

class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1) return s;

        int stringLength = s.length();

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            
            int index = row;
            boolean up = true;

            while(index < stringLength) {
                sb.append(s.charAt(index));

                if(row == 0 || row == numRows - 1) index += 2 * (numRows - 1);
                else {
                    if(up) index += 2 * (numRows - row - 1);
                    else index += 2 * row;
                    up = !up;
                }
            }
        }
        return sb.toString();
    }
}