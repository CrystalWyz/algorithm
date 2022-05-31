package study.zuo_algorithm.class20;

/**
 * @author wnx
 */
public class Code01_PalindromeSubsequence {

    public static int lpsl1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return f(s.toCharArray(), 0, s.length());
    }

    // str[L..R] 最长回文子序列长度返回
    public static int f(char[] chars,int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            return chars[L] == chars[R] ? 2 : 1;
        }

        int p1 = f(chars, L + 1, R - 1);
        int p2 = f(chars, L, R - 1);
        int p3 = f(chars, L + 1, R);
        int p4 = chars[L] == chars[R] ? 0 : (2 + f(chars, L + 1, R - 1));

        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    public static int lpsl2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = chars[i] == chars[i + 1] ? 2 : 1;
        }

        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                dp[L][R] = Math.max(dp[L][R - 1], dp[L + 1][R]);
                if (chars[L] == chars[R]) {
                    dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
                }
            }
        }

        return dp[0][N - 1];
    }
}
