package study.zuo_algorithm.class02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wnx
 */
public class Code02_KM {
    // 一个数组中有一种数出现了K次，其他数出现M次，且1<K<M,求出现K次的数
    public static int km(int[] arr, int k, int m) {
        int[] help = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                help[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            help[i] %= m;
            if (help[i] != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
