package study.zuo_algorithm.class12;

import javax.sound.sampled.DataLine.Info;

/**
 * @author wnx
 */
public class Code06_MaxDistance {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int m, int h) {
            maxDistance = m;
            height = h;
        }

    }

    private static Info process(Node node) {
        if (node == null) {
            return new Info(0, 0);
        }

        Info left = process(node.left);
        Info right = process(node.right);

        int height = Math.max(left.height, right.height) + 1;
        int maxDistance = Math.max(Math.max(left.maxDistance, right.maxDistance), left.height + right.height + 1);

        return new Info(maxDistance, height);
     }
}
