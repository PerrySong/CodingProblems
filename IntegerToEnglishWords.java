public class IntegerToEnglishWords {
    /**
         Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

         Example 1:

         Input: 123
         Output: "One Hundred Twenty Three"
         Example 2:

         Input: 12345
         Output: "Twelve Thousand Three Hundred Forty Five"
         Example 3:

         Input: 1234567
         Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
         Example 4:

         Input: 1234567891
         Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety

     */

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] threeZeros = new String[]{"", "Thousand ", "Million ", "Billion "};
        StringBuilder res = new StringBuilder();
        int i = 3;
        int divider = 1000000000;
        while (divider >= 1) {
            if (num / divider != 0) {
                res.append(hundredsToWords((num / divider)));
                res.append(threeZeros[i]);
                num = num % divider;
            }
            divider /= 1000;
            i--;
        }
        return res.toString().trim();
    }

    private static String hundredsToWords(int num) {
        String[] numbers = new String[]{"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen ", "Twenty "};
        String[] tens = new String[]{"Zero ", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};


        StringBuilder sb = new StringBuilder();
        if (num / 100 != 0) {
            sb.append(numbers[num / 100]);
            sb.append("Hundred ");
        }
        num %= 100;
        if (num < 20 && num > 0) {
            sb.append(numbers[num]);
        } else if (num >= 20) {
            sb.append(tens[num / 10]);
            if (num % 10 != 0)
                sb.append(numbers[num % 10]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(20));
    }
}
