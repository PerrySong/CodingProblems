public class AddBinary {
    /**
         Given two binary strings, return their sum (also a binary string).

         The input strings are both non-empty and contains only characters 1 or 0.

         Example 1:

         Input: a = "11", b = "1"
         Output: "100"
         Example 2:

         Input: a = "1010", b = "1011"
         Output: "10101"
     */
    public String addBinary(String a, String b) {
        if (a == null || b == null) return "";
        StringBuilder res = new StringBuilder();
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int i = aChar.length - 1, j = bChar.length - 1;
        int increment = 0;

        while (i >= 0 && j >= 0) {
            int aInt = aChar[i] - '0';
            int bInt = bChar[j] - '0';
            res.append(aInt ^ bInt ^ increment);
            increment = (aInt + bInt + increment) / 2;
            i--;
            j--;
        }

        while (i >= 0) {
            int aInt = aChar[i] - '0';
            res.append(aInt ^ increment);
            increment = (aInt + increment) / 2;
            i--;
        }
        while (j >= 0) {
            int bInt = bChar[j] - '0';
            res.append(bInt ^ increment);
            increment = (bInt + increment) / 2;
            j--;
        }
        if (increment == 1) res.append("1");
        return res.reverse().toString();
    }
}
