public class ImplementedStrStr {
    //With recursion:
    public int strStr(String haystack, String needle) {

        if (needle == null || needle == "") return 0;

        if (haystack == null) return -1;

        char[] cArr1 = haystack.toCharArray();
        char[] cArr2 = needle.toCharArray();
        for (int i = 0; i < cArr1.length; i++) {
            if (subString(cArr1, cArr2, i, 0)) return i;
        }
        return -1;
    }

    private boolean subString(char[] cArr1, char[] cArr2, int start, int index) {
        if (index == cArr2.length) {
            return true;
        }
        if (start + index >= cArr1.length || cArr1[start + index] != cArr2[index]) return false;
        return subString(cArr1, cArr2, start, index + 1);
    }

    public static void main(String[] args) {
        ImplementedStrStr s = new ImplementedStrStr();
        System.out.println(s.strStr("asd", "sd"));
    }
}
