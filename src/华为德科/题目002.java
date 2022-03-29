package 华为德科;

import java.util.Scanner;

/**
 * @author wnx
 */
public class 题目002 {
    //        给定两个整数数组
    //array1 array2  数组元素按升序排列
    // 假设从arr1 arr2中分别取出一个元素，可构成一对元素
    // 现在需要取出k对元素，并对取出的所有元素求和
    // 计算和的最小值
    // 注意：两对元素对应arr1 arr2的下标是相同的
    //       视为同一对元素

    //输入描述
    //    输入两行数组arr1 arr2
    //    每行首个数字为数组大小size   0<size<=100
    //    arr1，2中的每个元素   0< <1000
    //    接下来一行  正整数k   0<k<=arr1.size * arr2.size
    // 输出描述
    //   满足要求的最小值

    // 例子

    //输入
    //   3 1 1 2
    //   3 1 2 3
    //   2

    //输出
    //   4

    //说明：用例中需要取两个元素，
    // 取第一个数组第0个元素与第二个数组第0个元素组成一个元素
    // [1,1]
    //取第一个数组第1个元素与第二个数组第0个元素组成一个元素
    // [1,1]

    //求和为1+1+1+1=4 ,满足要求最小
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr1 = getArray(sc.nextLine());
        int[] arr2 = getArray(sc.nextLine());
        int k = sc.nextInt();

        int p1 = 0;
        int p2 = 0;
        int sum = 0;

        if(k == 0) {
            System.out.println(sum);
            return;
        }

        sum += arr1[0] + arr2[0];
        for (int i = 1; i < k; i++){
            if(arr1[p1 + 1] > arr2[p2 + 1]) {
                p2++;
            } else {
                p1++;
            }
            sum += arr1[p1] + arr2[p2];
        }
        System.out.println(sum);
    }

    private static int[] getArray(String nextLine) {
        String[] split = nextLine.split(" ");
        int[] res = new int[Integer.parseInt(split[0])];

        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(split[i + 1]);
        }
        return res;
    }
}
