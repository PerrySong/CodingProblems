public class ValidNumber {

    /**
     * Validate if a given string can be interpreted as a decimal number.

     Some examples:
     "0" => true
     " 0.1 " => true
     "abc" => false
     "1 a" => false
     "2e10" => true
     " -90e3   " => true
     " 1e" => false
     "e3" => false
     " 6e-1" => true
     " 99e2.5 " => false
     "53.5e93" => true
     " --6 " => false
     "-+3" => false
     "95a54e53" => false

     Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
     implementing one. However, here is a list of characters that can be in a valid decimal number:

     Numbers 0-9
     Exponent - "e"
     Positive/negative sign - "+"/"-"
     Decimal point - "."
     Of course, the context of these characters also matters in the input.

     Update (2015-02-10):
     The signature of the C++ function had been updated. If you still see your function signature accepts a const char *
     argument, please click the reload button to reset your code definition.
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.equals("")) return false;
        s = s.trim();
        if (s.equals("")) return false;
        if (s.contains("e")) {
            String[] nums = s.split("e");
            if (nums.length != 2) return false;
            if (isDouble(nums[0]) && isNoSignInt(nums[1]))
                return true;
        }
        return isDouble(s);
    }

    public boolean isNoSignInt(String s) {
        s = s.trim();
        if (s == null || s.equals("")) return false;
        for (char c : s.toCharArray()) {
            if (c - '0' > 9 || c - '0' < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isDouble(String s) {
        s = s.trim();
        if (s == null || s.equals("")) return false;
        if (s.startsWith("+") || s.startsWith("-")) s = s.substring(1);
        int point = 0;
        for (char c : s.toCharArray()) {
            if (c - '0' > 9 || c - '0' < 0) {
                if (c != '.') return false;
                if (point != 0) return false;
                point++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidNumber a = new ValidNumber();
        System.out.println(a.isNumber("e7e69e"));
    }
}
