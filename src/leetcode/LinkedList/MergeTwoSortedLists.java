package leetcode.LinkedList;

/**
 * leetcode 21
 */
public class MergeTwoSortedLists {
    /**
     * 利用归并的思想去解决这个问题，不需要重新开辟一个链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
        {
            return l2;
        }
        if(l2 == null)
        {
            return l1;
        }

        ListNode node = null;
        // 以最小的链表作为拼接的链表
        if(l1.val <= l2.val)
        {
            node = l1;
            l1 = l1.next;
        }
        else
        {
            node = l2;
            l2 = l2.next;
        }

        ListNode head = node;

        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                node.next = l1;
                node = node.next;

                l1 = l1.next;
            }
            else
            {
                node.next = l2;
                node = node.next;

                l2 = l2.next;
            }
        }

        if(l1 != null)
        {
            node.next = l1;
        }
        else if(l2 != null)
        {
            node.next = l2;
        }

        return head;

    }
}
