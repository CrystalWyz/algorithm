package 华为德科;

import java.util.Scanner;

/**
 * @author wnx
 */
public class 题目003 {
    /*
            给出n阶方阵里所有数
            求方阵里所有数的和
            输入描述：
              输入有多个测试用例
              每个测试用例第一个第一个整数n   n<=1000 表示方阵阶数为n
              接下来是n行的数字，每行n个数字用空格隔开
            输出描述：
              输出一个整数表示n阶方阵的和
            例子：
              输入
                  3
                  1 2 3
                  2 1 3
                  3 2 1
              输出
                  18
             */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                sum += Integer.parseInt(split[j]);
            }
        }
        System.out.println(sum);

        in.close();
    }
}
