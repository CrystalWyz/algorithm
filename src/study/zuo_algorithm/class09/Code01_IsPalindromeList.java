package study.zuo_algorithm.class09;

import java.util.LinkedList;

/**
 * @author wnx
 */
public class Code01_IsPalindromeList {

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // O(n)
    public static boolean isPalindromeList01(Node head) {
        LinkedList<Node> stack = new LinkedList<>();
        Node cur = head;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {

            if (cur.value != stack.pop().value) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }

    // O(n/2)
    public static boolean isPalindromeList02(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node cur = head;
        Node fast = head;
        LinkedList<Node> stack = new LinkedList<>();
        while (fast.next != null && fast.next.next != null) {
            stack.push(cur);
            cur = cur.next;
            fast = fast.next.next;
        }

        // 去除奇数中点
        if (fast.next == null) {
            stack.pop();
        }

        cur = cur.next;
        while (cur != null) {
            if (cur.value != stack.pop().value) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }
}
