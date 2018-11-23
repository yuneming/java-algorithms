package leetcode.LinkedList;

/**
 * leetcode 86
 */
public class PartitionList {
    // 开辟俩个链表
    public ListNode partition(ListNode head, int x) {
        // 头结点
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        // 当前结点
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        // important! avoid cycle in linked list.
        // otherwise u will get TLE.
        // 防止形成环，最后将第二个链表末尾置空
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;

    }
}
