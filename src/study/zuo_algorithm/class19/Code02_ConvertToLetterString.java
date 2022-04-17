package study.zuo_algorithm.class19;

/**
 * @author wnx
 */
public class Code02_ConvertToLetterString {

    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    public static int process(char[] str, int i) {

        if (i == str.length) {
            return 1;
        }

        if (str[i] == '0') {
            return 0;
        }
        // i 单转
        int ways = process(str, i + 1);
        // 联合
        if (i + 1 < str.length && (str[i] - '0' * 10 + str[i + 1] - '0' < 27)) {
            ways += process(str, i + 2);
        }

        return ways;
    }

    public static int dp1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            int ways = dp[i + 1];
            if (i + 1 < chars.length && (chars[i] - '0' * 10 + chars[i + 1] - '0' < 27)) {
                ways += dp[i + 2];
            }
        }
        return dp[0];
    }
}
