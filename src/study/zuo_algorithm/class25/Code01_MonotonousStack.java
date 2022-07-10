package study.zuo_algorithm.class25;

import java.util.Stack;

/**
 * @author wnx
 */
public class Code01_MonotonousStack {

    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int j = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                res[j][0] = l;
                res[j][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int l = stack.isEmpty() ? -1 : stack.peek();
            res[j][0] = l;
            res[j][1] = -1;
        }

        return res;
    }
}
