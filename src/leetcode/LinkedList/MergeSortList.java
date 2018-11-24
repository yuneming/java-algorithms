package leetcode.LinkedList;

/**
 * leetcode 148
 */
public class MergeSortList {
    /**
     * 1.归并排序的整体思想
     * 2.找到一个链表的中间节点的方法
     * 3.合并俩个已拍好序的链表为一个新的有序链表
     * 4.递归的压栈操作
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;
        //注意，这里不能写成while (fast.next != null && fast.next.next != null)，因为，在只有两个node的情况下fast和slow指针还是需要向下走，否则无法分解成一个node.
        // 寻找中间节点
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            // fast每次都步长都是2，fast到末尾的时候slow刚好是链表的一半
            fast = fast.next.next;
        }
        //note: 这里需要一个pre指针来保存slow的上一个node，因为需要把上一个node的next设为null.
        //把前面的和后面的分开，形成俩个链表，相当于链条给弄成了俩条
        pre.next = null;
        //merge的时候，参数是两个sort好的linkedlist的head，需要使用sortList的返回值。
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);

    }
    public static ListNode merge(ListNode head, ListNode head2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (head != null && head2 != null) {
            if (head.val < head2.val) {
                p.next = head;
                head = head.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head != null) {
            p.next = head;
        }
        if (head2 != null) {
            p.next = head2;
        }
        return dummy.next;
    }
    public static void main(String[] args){
            int[] nums = {4, 2, 1, 3};
            ListNode head = new ListNode(nums);
            sortList(head);
    }
}
