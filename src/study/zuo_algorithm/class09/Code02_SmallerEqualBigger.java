package study.zuo_algorithm.class09;

import org.w3c.dom.Node;

import java.util.Arrays;

/**
 * @author wnx
 */
public class Code02_SmallerEqualBigger {

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int pivot) {

        if (head == null) {
            return null;
        }

        Node cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int[] nodes = new int[len];
        cur = head;
        int i = 0;
        while (cur != null) {
            nodes[i++] = cur.value;
            cur = cur.next;
        }

        Arrays.sort(nodes);

        cur = head;
        for (int value : nodes) {
            cur.value = value;
            cur = cur.next;
        }

        return head;
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;

        Node next;
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }

        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }
}
