package study.zuo_algorithm.class12;

/**
 * @author wnx
 */
public class Code03_IsBalanced {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalanced1(Node head) {
        return process(head).isBalanced;
    }

    private static Info process(Node node) {
        if (node == null) {
            return new Info(true, 0);
        }

        Info left = process(node.left);
        Info right = process(node.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = true;
        if (!left.isBalanced || !right.isBalanced || Math.abs(left.height - right.height) > 1) {
            isBalanced = false;
        }

        return new Info(isBalanced, height);
    }

    public static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
