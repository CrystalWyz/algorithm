package leetcode;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */
abstract class Reader4 {
    int read4(char[] buf4) {
        return 0;
    }
}
class Read extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int degree = (n + 3) / 4;
        int res = 0;
        char[] buf4 = new char[4];
        int index = 0;
        while (degree > 0) {
            int read = read4(buf4);
            read = Math.min(read, n);
            res += read;
            for(int i = 0; i < read; i++) {
                buf[index++] = buf4[i];
            }
            n -= read;
            degree--;
        }
        return res;
    }
}