package study.zuo_algorithm.class04;

/**
 * @author wnx
 */
public class Code02_smallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int pl = l;
        int pr = mid + 1;
        int res = 0;

        while (pl <= mid && pr <= r) {
            res += arr[pl] < arr[pr] ? arr[pl] * (r - pr + 1) : 0;
            help[index++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
        }

        while (pl <= mid) {
            help[index++] = arr[pl++];
        }

        while (pr <= r) {
            help[index++] = arr[pr++];
        }

        System.arraycopy(help, 0, arr, l, help.length);

        return res;
    }
}
