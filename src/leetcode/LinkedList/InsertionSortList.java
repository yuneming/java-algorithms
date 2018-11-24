package leetcode.LinkedList;

/**
 * leetcode 147
 */
public class InsertionSortList {
    /**
     * 创建一个排好序的链表，然后不断往排好序的链表中插入数据
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        // 排好序的链表
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            pre = dummy;
            // 从伪头结点的下一个结点开始，(注意判空)
            // 让pre指向小于cur.val的最大结点（升序）
            while (pre.next != null
                    && pre.next.val < cur.val) {

                pre = pre.next;
            }
            // next暂存cur的下一个结点
            ListNode next = cur.next;
            // 把cur连接在pre后面
            // cur.next指向pre.next
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;

    }
}
