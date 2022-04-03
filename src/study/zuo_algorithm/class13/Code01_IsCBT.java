package study.zuo_algorithm.class13;

/**
 * @author wnx
 */
public class Code01_IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head) {
        return process(head).isCBT;
    }

    private static Info process(Node node) {
        if (node == null) {
            return new Info(true, true, 0);
        }

        Info left = process(node.left);
        Info right = process(node.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isFull = left.isFull && right.isFull && left.height == right.height;
        boolean isCBT = false;
        if (left.isFull && right.isFull && left.height == right.height) {
            isCBT = true;
        } else if (left.isCBT && right.isFull && left.height == right.height + 1) {
            isCBT = true;
        } else if (left.isFull && right.isFull && left.height == right.height + 1) {
            isCBT = true;
        } else if (left.isFull && right.isCBT && left.height == right.height) {
            isCBT = true;
        }
        return new Info(isFull, isCBT, height);
    }

    private static class Info {
        boolean isCBT;
        boolean isFull;
        int height;

        public Info(boolean isCBT, boolean isFull, int height) {
            this.isCBT = isCBT;
            this.isFull = isFull;
            this.height = height;
        }
    }
}
