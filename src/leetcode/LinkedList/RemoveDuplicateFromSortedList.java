package leetcode.LinkedList;

/**
 * leetcode 83
 */
public class RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            // 重复值的情况
            if (pre.val == cur.val){
                if (cur.next != null){
                    pre.next = cur.next;
                    cur = pre.next;
                }else {
                    pre.next = cur.next;
                    cur.next = null;
                }

            }else {
                pre = pre.next;
                cur = cur.next;
            }

        }
        return head;
    }
}
