package study.zuo_algorithm.class12;

import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * @author wnx
 */
public class Code05_MaxSubBSTSize {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static int maxSubBSTSize1(Node head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
    }

    public static int maxSubBSTSize2(Node head) {
        if(head == null) {
            return 0;
        }
        return process(head).maxBSTSubtreeSize;
    }

    private static Info process(Node node) {
        if (node == null) {
            return null;
        }

        Info left = process(node.left);
        Info right = process(node.right);

        int max = node.value;
        int min = node.value;
        int allSize = 1;
        int leftMaxBSTSize = -1;
        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
            allSize += left.size;
            leftMaxBSTSize = left.maxBSTSubtreeSize;
        }
        int rightMaxBSTSize = -1;
        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
            allSize += right.size;
            rightMaxBSTSize = right.maxBSTSubtreeSize;
        }

        // node 自己能否成为BST
        int nodeBSTSize = -1;
        boolean leftBST = left == null || (left.maxBSTSubtreeSize == left.size);
        boolean rightBST = right == null || (right.maxBSTSubtreeSize == right.size);
        if (leftBST && rightBST) {
            boolean leftMaxLessX = left == null || (left.max < node.value);
            boolean rightMinMoreX = right == null || (node.value < right.min);
            if (leftMaxLessX && rightMinMoreX) {
                int leftSize = left == null ? 0 : left.size;
                int rightSize = right == null ? 0 : right.size;
                nodeBSTSize = leftSize + rightSize + 1;
            }
        }
        return new Info(Math.max(leftMaxBSTSize, Math.max(rightMaxBSTSize, nodeBSTSize)), allSize, max, min);
    }

    private static class Info {
        int maxBSTSubtreeSize;
        int size;
        int max;
        int min;

        public Info(int maxBSTSubtreeSize, int size, int max, int min) {
            this.maxBSTSubtreeSize = maxBSTSubtreeSize;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
}
