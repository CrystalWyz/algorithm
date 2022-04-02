import java.util.Map;

class Solution {
    int[] rec;
    public int climbStairs(int n) {
        rec = new int[n + 1];
        return recursion(n);
    }

    public int recursion(int n) {
        if (n <= 2){
            rec[n] = n;
            return n;
        }
        if (rec[n] != 0) {
            return rec[n];
        }
        int variety = recursion(n - 1) + recursion(n - 2);
        rec[n] = variety;
        return recursion(n - 1) + recursion(n - 2);
    }
}