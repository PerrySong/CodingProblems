public class ReadNCharactersGivenRead4IICallMultipleTimes {
    /**
     *
     */

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    private int presize = 0;
    private int preindex = 0;
    private char[] tmp = new char[4];

    public int read(char[] buf, int n) {
        if (buf == null || buf.length == 0) return 0;
        int index = 0;
        while (index < n) {
            if (preindex < presize) {
                buf[index++] = tmp[preindex++];
            } else {
                presize = read4(tmp);
                preindex = 0;
                if (presize == 0) {
                    return index;
                }
            }
        }
        return index;
    }

    public int read4(char[] buf) {
        return 4;
    }
}
