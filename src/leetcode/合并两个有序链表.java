package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// @solution-sync:begin
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        if(cur1.val <= cur2.val) {
            head = cur1;
            cur1 = cur1.next;
        } else {
            head = cur2;
            cur2 = cur2.next;
        }

        ListNode cur = head;
        while (cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }

        return head;
    }
}