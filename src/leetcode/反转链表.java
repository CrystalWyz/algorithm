package leetcode;

// @solution-sync:begin
class ReverseList {
    public ListNode reverseList(ListNode head) {
        //!!!精妙
       if(head == null || head.next == null) {
           return head;
       }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}