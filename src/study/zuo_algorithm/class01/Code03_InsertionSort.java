package study.zuo_algorithm.class01;

import java.util.Arrays;

public class Code03_InsertionSort {

    //插入排序：将前缀看成有序数组，将后续数依次插入
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // 绝对正确的比较器 用于比较排序结果
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 数组长度
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];

        // 生成数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1) - (Math.random() * maxValue));
        }

        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }

        return Arrays.copyOf(arr,arr.length);
    }

    public static boolean isEuqal(int[] arr1, int[] arr2) {
        return Arrays.compare(arr1, arr2) == 0;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int testTime = 50_000;
        int maxSize = 1000;
        int maxValue = 1000;

        boolean succeed = true;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arrCopy = copyArray(arr);

            insertionSort(arr);
            comparator(arrCopy);

            if (!isEuqal(arr, arrCopy)) {
                succeed = false;
                printArray(arr);
                printArray(arrCopy);
                break;
            }
        }

        System.out.println(succeed ? "Nice" : "Oh my god!");
        System.out.println("测试结束");
    }
}
