package study.zuo_algorithm.class13;

import javax.sound.sampled.DataLine.Info;

/**
 * @author wnx
 */
public class Code02_MaxSubBSTHead {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node maxSubBSTHead(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).maxSubBSTHead;
    }

    private static class  Info {
        Node maxSubBSTHead;
        int maxSubBSTSize;
        int max;
        int min;

        public Info(Node maxSubBSTHead, int maxSubBSTSize, int max, int min) {
            this.maxSubBSTHead = maxSubBSTHead;
            this.maxSubBSTSize = maxSubBSTSize;
            this.max = max;
            this.min = min;
        }
    }

    private static Info process(Node node) {
        if (node == null) {
            return null;
        }

        Info left = process(node.left);
        Info right = process(node.right);

        Node maxSubBSTHead = null;
        int maxSubBSTSize = 0;
        int max = node.value;
        int min = node.value;

        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.max(min, left.min);
            maxSubBSTHead = left.maxSubBSTHead;
            maxSubBSTSize = left.maxSubBSTSize;
        }
        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.max(min, right.min);
            if (right.maxSubBSTSize > maxSubBSTSize) {
                maxSubBSTHead = right.maxSubBSTHead;
                maxSubBSTSize = right.maxSubBSTSize;
            }
        }

        if ((left == null ? true : (left.maxSubBSTHead == node.left && left.max < node.value)) &&
                (right == null ? true : (right.maxSubBSTHead == node.right && right.min > node.value))) {
            maxSubBSTHead = node;
            maxSubBSTSize = (left == null ? 0 : left.maxSubBSTSize) + (right == null ? 0 : right.maxSubBSTSize) + 1;
        }

        return new Info(maxSubBSTHead, maxSubBSTSize, max, min);
    }
}
