package study.zuo_algorithm.class03;

import org.w3c.dom.Node;

/**
 * @author wnx
 */
public class Code02_DeleteGivenValue {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node revomeValue(Node head, int value) {
        // 处理head
        while (head != null) {
            if(head.value == value) {
                head = head.next;
            } else {
                break;
            }
        }
        if(head == null) {
            return null;
        }

        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if(cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
