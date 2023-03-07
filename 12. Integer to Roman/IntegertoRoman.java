public class IntegertoRoman {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(2020));
    }
}

enum Romans {

    I('I', 1),
    V('V', 5),
    X('X', 10),
    L('L', 50),
    C('C', 100),
    D('D', 500),
    M('M', 1000);

    private final char romanNum;
    private final int arabicNum;

    private Romans(char romanNum, int arabicNum) {
        this.romanNum = romanNum;
        this.arabicNum = arabicNum;
    }

    public char returnRoman() {
        return romanNum;
    }

    public int returnArabic() {
        return arabicNum;
    }

}

class Solution {
    public String intToRoman(int num, Romans[] romans, StringBuilder romanEqu, int enumPos) {

        if (num == 0)
            return romanEqu.toString();

        int indNumToSub = enumPos % 2 == 0 ? enumPos - 2 : enumPos - 1;

        if (num / romans[enumPos].returnArabic() >= 1) {
            num -= romans[enumPos].returnArabic();
            romanEqu.append(romans[enumPos].returnRoman());
        } else if (num / (romans[enumPos].returnArabic() - romans[indNumToSub].returnArabic()) >= 1) {
            num -= romans[enumPos].returnArabic() - romans[indNumToSub].returnArabic();
            romanEqu.append(new char[] { romans[indNumToSub].returnRoman(), romans[enumPos].returnRoman() });
        } else
            enumPos--;

        return intToRoman(num, romans, romanEqu, enumPos);
    }

    public String intToRoman(int num) {
        return intToRoman(num, Romans.values(), new StringBuilder(), Romans.values().length - 1);
    }
}