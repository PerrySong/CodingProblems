public class ShortestPalindrome {


    /**
     * Brute force
     * @param
     */
//    public String shortestPalindrome(String s) {
//        if(s == null || s.length() == 0 || s.length() == 1) return s;
//        StringBuilder rs = new StringBuilder(s);
//        rs = rs.reverse();
//        int i = s.length() - 1;
//        for(; i > 0; i--) {
//            if(rs.charAt(i) == s.charAt(s.length() - i - 1))
//                break;
//
//        }
//        return rs.substring(0, s.length() - i) + s;
//    }

    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;

        String ns = s + "#" + new StringBuilder(s).reverse();
        char[] cArr = ns.toCharArray();
        int[] position = new int[ns.length()];
        for(int i = 1; i < ns.length(); i++) {
            if(cArr[i] == cArr[position[i - 1]]) {
                position[i] = position[i - 1] + 1;
            } else {
                int prepos = position[i - 1];
                while(prepos > 0 && cArr[prepos] != cArr[i])
                    prepos = position[prepos - 1];

                position[i] = cArr[prepos] != cArr[i] ? 0 : (prepos + 1);
            }
        }
        System.out.println(ns.length() - position[ns.length() - 1] + 1);
        return new StringBuilder(s).reverse().substring(0, s.length() - position[ns.length() - 1]) + s;
    }

    public static void main(String[] args) {
        ShortestPalindrome a = new ShortestPalindrome();
        System.out.println(a.shortestPalindrome("aacecaaa"));
    }
}

/**
 *
 *       cabcbd abcabcbd
 *              ^ ^
 */