public class DecodeString {
    public static String decodeString(String s) {

        while (s.contains("[")) {
            StringBuilder res = new StringBuilder();
            int intIndex = 0;
            int preOpenIndex = 0;
            int times = 0;
            char[] charArr = s.toCharArray();

            for (int i = 0; i < charArr.length; i++) {
                if (Character.isDigit(charArr[i])) {
                    if(preOpenIndex != 0) {
                        times = charArr[i] - '0';
                        intIndex = i;
                    } else {
                        if (times == 0)
                            intIndex = i;
                        times = 10 * times + (charArr[i] - '0');
                    }
                }

                if (charArr[i] == '[') {
                    preOpenIndex = i;
                    // Reset times
                } else if (charArr[i] == ']') {
                     System.out.println(times);
                    System.out.println(intIndex);
                    for (int j = 0; j < times; j++) {

                        res.append(s.substring(preOpenIndex + 1, i));
                    }

                    res.insert(0, s.substring(0, intIndex));
                    res.append(s.substring(i + 1));
                    break;
                }

            }
            s = res.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
