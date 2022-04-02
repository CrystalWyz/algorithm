package leetcode;

// @solution-sync:begin
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode cur = head;
        int scale = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + scale) % 10);
            scale = (l1.val + l2.val + scale) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        while (l1 != null) {
            cur.next = new ListNode((l1.val + scale) % 10);
            scale = (l1.val + scale) / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + scale) % 10);
            scale = (l2.val + scale) / 10;
            l2 = l2.next;
            cur = cur.next;
        }

        if (scale == 1) {
            cur.next = new ListNode(1);
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}