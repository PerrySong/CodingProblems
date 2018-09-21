public class ReadNCharactersGivenRead4 {
    /**
         The API: int read4(char *buf) reads 4 characters at a time from a file.

         The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

         By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

         Example 1:

         Input: buf = "abc", n = 4
         Output: "abc"
         Explanation: The actual number of characters read is 3, which is "abc".
         Example 2:

         Input: buf = "abcde", n = 5
         Output: "abcde"
         Note:
         The read function will only be called once for each test case.
     */
    public int read(char[] buf, int n) {
        if (buf == null) return 0;
        char[] tmp = new char[4];
        int count = 0;
        while (true) {
            int read = read4(tmp);
            int i = 0;
            while (count < n && i < read) {
                buf[count++] = tmp[i++];
            }
            if (count == n || read < 4) break;
        }
        return count;
    }

    private int read4(char[] buf) {
        return 4;
    }
}
