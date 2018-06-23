public class ZigZagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string s, int numRows);
     * Example 1:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */

    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows >= s.length() || numRows == 1) return s;
        StringBuilder[] sbs =  new StringBuilder[s.length()];
        boolean down = true;
        int count = 0;

        for(int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int curPos = 0;
        for(int i = 0; i < len; i++) {
            if(down) {
                sbs[curPos++].append(s.charAt(i));
                if(curPos == numRows) {
                    curPos = numRows - 2;
                    down = false;
                }
            } else {
                sbs[curPos--].append(s.charAt(i));
                if(curPos == -1) {
                    curPos = 1;
                    down = true;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            res.append(sbs[i]);
        }

        return res.toString();

    }

    public static void main(String[] args) {
        ZigZagConversion a = new ZigZagConversion();
        a.convert("PAYPALISHIRING", 3);
    }
}