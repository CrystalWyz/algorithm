package study.zuo_algorithm.class08;

public class Code03_RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        radixSort(arr, maxbits(arr));
    }

    private static void radixSort(int[] arr, int maxbits) {
        final int radix = 10;
        int[] help = new int[arr.length];
        for (int d = 1; d < maxbits; d++) {
            int[] count = new int[radix];

            for (int j : arr) {
                int dNum = getDigit(j, d);
                count[dNum]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                int dNum = getDigit(arr[i], d);
                help[count[dNum] - 1] = arr[i];
                count[dNum]--;
            }

            System.arraycopy(help, 0, arr, 0, help.length);
        }
    }

    private static int getDigit(int num, int d) {
        return ((num / ((int) Math.pow(10, d - 1))) % 10);
    }

    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        int res = 0;
        while (max > 0) {
            res++;
            max /= 10;
        }

        return res;
    }
}
