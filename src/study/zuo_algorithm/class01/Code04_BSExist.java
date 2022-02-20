package study.zuo_algorithm.class01;

import java.util.Arrays;

/**
 * @author wnx
 */
public class Code04_BSExist {

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;

        while (L < R) {
            mid = L + ((R - L) >> 1);
            if(sortedArr[mid] > num) {
                R = mid - 1;
            } else if (sortedArr[mid] < num) {
                L = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean comparetor(int[] sortedArr, int num) {
        for(int cur : sortedArr) {
            if(cur == num) {
                return true;
            }
        }
        return false;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (comparetor(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "fail");
        System.out.println("测试结束");
    }
}
