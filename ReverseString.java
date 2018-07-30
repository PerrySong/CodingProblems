public class ReverseString {
    /**

         Write a function that takes a string as input and returns the string reversed.

         Example:
         Given s = "hello", return "olleh".
     */

    public String reverseString(String s) {
        char[] cArray = s.toCharArray();
        int i = 0, j = cArray.length - 1;
        while (i < j) {
            char temp = cArray[i];
            cArray[i] = cArray[j];
            cArray[j] = temp;
            i++;
            j--;
        }
        return new String(cArray);
    }
}
