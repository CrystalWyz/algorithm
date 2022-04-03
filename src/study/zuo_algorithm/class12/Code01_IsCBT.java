package study.zuo_algorithm.class12;

import java.util.LinkedList;
import java.util.Queue;

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

    public static boolean isBCT(Node head) {
        if (head == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        boolean leaf = false;
        Node l = null;
        Node r = null;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            l = poll.left;
            r = poll.right;
            if ((leaf && (l == null || r == null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }

        return true;
    }
}
