package study.zuo_algorithm.class05;

/**
 * @author wnx
 */
public class Code01_CountOfRangeSum {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return process(prefixSum, 0, prefixSum.length - 1, lower, upper);
    }

    private static int process(long[] arr, int l, int r, int lower, int upper) {
        if (l == r) {
            return arr[l] >= lower && arr[l] <= upper ? 1 : 0;
        }

        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid, lower, upper) + process(arr, mid + 1, r, lower, upper) + merge(arr, l, mid, r, lower, upper);
    }

    private static int merge(long[] arr, int l, int mid, int r, int lower, int upper) {

        int res = 0;
        int cl = l;
        int cr = l;
        for(int i = mid + 1; i <= r; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - min;

            while (cr <= mid && arr[cr] <= max) {
                cr++;
            }
            while (cl <= mid && arr[cl] < min) {
                cl++;
            }
            res += cr - cl;
        }

        long[] help = new long[r - l + 1];
        int index = 0;
        int pl = l;
        int pr = mid + 1;

        while (pl <= mid && pr <= r) {
            help[index++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];
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
