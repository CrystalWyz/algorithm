package 华为德科;

import java.util.Scanner;

/**
 * @author wnx
 */
public class 题目005 {
    /*
         一天一只顽猴想要从山脚爬到山顶
          途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
          试问？猴子通过这个阶梯有多少种不同的跳跃方式

          输入描述：
            输入只有一个这个数n    0<n<50
            此阶梯有多个台阶
          输出描述：
            有多少种跳跃方式

          实例:
           输入
             50
           输出
              122106097

           输入
              3
           输出
              2
         */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(process(n));

        in.close();
    }

    private static int process(int num) {
        if (num <= 0) {
            return 0;
        }
        if(num == 1 || num == 2) {
            return 1;
        }
        if (num == 3) {
            return 2;
        }
        return process(num - 1) + process(num - 3);
    }
}
