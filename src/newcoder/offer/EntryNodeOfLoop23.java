package newcoder.offer;

import leetcode.LinkedList.ListNode;

public class EntryNodeOfLoop23 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead.next, fast = pHead.next.next;
        while (slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
