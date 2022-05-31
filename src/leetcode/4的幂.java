package leetcode;

class IsPowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n < 0 || (n & (n - 1)) != 0) {
            return false;
        }
        return n % 3 == 1;
    }
}