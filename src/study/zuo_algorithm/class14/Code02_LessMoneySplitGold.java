package study.zuo_algorithm.class14;

import java.util.PriorityQueue;

/**
 * @author wnx
 */
public class Code02_LessMoneySplitGold {

    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int j : arr) {
            pQ.add(j);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
