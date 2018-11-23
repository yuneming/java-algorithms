package leetcode.LinkedList;

/**
 * leetcode 82
 */
public class RemoveDuplicatesFromSortedListII {
    /**
     * 删除全部重复元素
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null){
            return null;
        }
        // 创建虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        int flagVal = Integer.MAX_VALUE;
        while (cur.next != null){
            // 重复值的情况
            if (cur.val == cur.next.val){
                pre.next = cur.next;
                flagVal = cur.val;
                cur = pre.next;


            }else if (cur.val == flagVal){
                pre.next = cur.next;
                cur = pre.next;

            }
            else {
                // 使重复标记值不为链表中没访问过的值，防止误删除元素
                flagVal = pre.val;
                pre = pre.next;
                cur = cur.next;
            }

        }
        if (cur.val == flagVal){
            pre.next = cur.next;
            cur = pre.next;
        }
        return dummyHead.next;
    }
}
