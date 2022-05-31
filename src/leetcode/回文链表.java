package leetcode;

import java.util.LinkedList;

// @solution-sync:begin
class IsPalindromeLink {
    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = head;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {

            if (cur.val != stack.pop().val) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}