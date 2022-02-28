package study.zuo_algorithm.class04;

/**
 * @author wnx
 */
public class Code04_BiggerThanRightTwice {

    public static int biggerThanRightTwice(int[] arr) {
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
        int index = help.length - 1;
        int pl = mid;
        int pr = r;

        int countIndex = mid + 1;
        int res = 0;
        for (int i = l; i <= mid; i++) {
            while(countIndex <= pr && (long) arr[i] > (long) arr[countIndex] * 2) {
                countIndex++;
            }
            res += countIndex - mid - 1;
        }

        while (pl >= l && pr > mid) {
            help[index--] = arr[pl] > arr[pr] ? arr[pl--] : arr[pr--];
        }

        while (pl >= l) {
            help[index--] = arr[pl--];
        }

        while (pr > mid) {
            help[index--] = arr[pr--];
        }

        System.arraycopy(help, 0, arr, l, help.length);

        return res;
    }
}
