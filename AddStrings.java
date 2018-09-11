public class AddStrings {
    /**
         Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

         Note:

         The length of both num1 and num2 is < 5100.
         Both num1 and num2 contains only digits 0-9.
         Both num1 and num2 does not contain any leading zero.
         You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) return num1 + num2;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder res = new StringBuilder();

        int tmp = 0;
        while (i >= 0 && j >= 0) {
            int num = num1.charAt(i--) - '0' + num2.charAt(j--) - '0' + tmp;
            if (num >= 10) tmp = 1;
            else tmp = 0;
            res.append(num % 10);
        }
        while (i >= 0) {
            int num = num1.charAt(i--)  - '0' + tmp;
            if (num >= 10) tmp = 1;
            else tmp = 0;
            res.append(num % 10);
        }

        while (j >= 0) {
            int num = num2.charAt(j--) - '0' + tmp;
            if (num >= 10) tmp = 1;
            else tmp = 0;
            res.append(num % 10);
        }
        if (tmp == 1) res.append(1);
        return res.reverse().toString();
    }
}
