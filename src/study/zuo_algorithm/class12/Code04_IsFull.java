package study.zuo_algorithm.class12;

/**
 * @author wnx
 */
public class Code04_IsFull {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isFull1(Node head) {
        if (head == null) {
            return true;
        }
        Info1 all = process1(head);
        return (1 << all.height) - 1 == all.nodes;
    }

    public static class Info1 {
        public int height;
        public int nodes;

        public Info1(int h, int n) {
            height = h;
            nodes = n;
        }
    }

    public static Info1 process1(Node head) {
        if (head == null) {
            return new Info1(0, 0);
        }
        Info1 leftInfo = process1(head.left);
        Info1 rightInfo = process1(head.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info1(height, nodes);
    }

    public static boolean isFull2(Node head) {
        if (head == null) {
            return true;
        }
        return process2(head).isFull;
    }

    public static class Info2 {
        public boolean isFull;
        public int height;

        public Info2(boolean f, int h) {
            isFull = f;
            height = h;
        }
    }

    public static Info2 process2(Node h) {
        if (h == null) {
            return new Info2(true, 0);
        }
        Info2 leftInfo = process2(h.left);
        Info2 rightInfo = process2(h.right);
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info2(isFull, height);
    }
}
