package study.zuo_algorithm.class04;

/**
 * @author wnx
 */
public class Code01_MergeSort {

    // 归并 -> 递归
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
    }


    // 归并 -> 循环
    private static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int step = 1;
        while (step < arr.length) {
            int l = 0;
            while (l < arr.length) {
                if (step >= arr.length - l) {
                    return;
                }

                int mid = l + step;
                int r = mid + Math.min(step, arr.length - mid - 1);
                merge(arr, l, mid, r);
                l = r + 1;
            }

            if(step > arr.length / 2) {
                break;
            }
            step <<= 1;
        }
    }
}
