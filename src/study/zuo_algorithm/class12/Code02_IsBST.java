package study.zuo_algorithm.class12;

import java.util.ArrayList;

/**
 * @author wnx
 */
public class Code02_IsBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        ArrayList<Integer> values = new ArrayList<>();
        in(head,values);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) <= values.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void in(Node node, ArrayList<Integer> values) {
        if (node == null) {
            return;
        }

        in(node.left, values);
        values.add(node.value);
        in(node.right, values);
    }

    public static boolean isBST2(Node head) {
        return process(head).isBST;
    }

    private static Info process(Node node) {
        if (node == null) {
            return null;
        }

        Info left = process(node.left);
        Info right = process(node.right);

        int max = node.value;
        int min = node.value;
        boolean isBST = true;

        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
            if (!left.isBST || left.max >= node.value) {
                isBST = false;
            }
        }
        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
            if (!right.isBST || right.max >= node.value) {
                isBST = false;
            }
        }
        return new Info(isBST, max, min);
    }

    public static class Info {
        boolean isBST;
        int max;
        int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
}
