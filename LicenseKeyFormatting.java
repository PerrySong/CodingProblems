public class LicenseKeyFormatting {
    /**
     *
         public String licenseKeyFormatting(String S, int K) {
         StringBuilder res = new StringBuilder();
         S = S.replaceAll("-", "");
         S = S.toUpperCase();
         char[] chars = S.toCharArray();
         for (int i = chars.length - 1; i >= 0;) {
         for (int j = 0; j < K && i >= 0; j++) {
         res.append(chars[i--]);
         }
         if (i >= 0)
         res.append("-");

         }
         return res.reverse().toString();
         }
     */

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        S = S.replaceAll("-", "");
        S = S.toUpperCase();
        char[] chars = S.toCharArray();
        for (int i = chars.length - 1; i >= 0;) {
            for (int j = 0; j < K && i >= 0; j++) {
                res.append(chars[i--]);
            }
            if (i >= 0)
                res.append("-");

        }
        return res.reverse().toString();
    }
}
