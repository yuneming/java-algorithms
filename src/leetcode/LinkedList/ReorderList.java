package leetcode.LinkedList;

/**
 * leetcode 143
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        // 当元素不超过俩个的情况
        if (head == null || head.next == null || head.next.next == null ){
            return;
        }
        // 双指针 fast和slow
        ListNode fast=head, slow=head, second;
        //链表切分成前后两个
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        second = slow.next;
        slow.next = null;
        //将后面那个链表进行翻转
        ListNode pre=null, next;
        while(second != null){
            next = second.next;
            second.next = pre;
            pre = second;
            second =  next;
        }
        //将两个链表合并，把第二个链表的每个元素插在第一个链表的后面即可
        fast = head;
        while(pre!=null){
            next = pre;
            pre = pre.next;
            next.next = fast.next;
            fast.next = next;
            fast = fast.next.next;
        }


    }
}
