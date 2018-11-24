package leetcode.LinkedList;

/**
 * leetcode 234
 */
public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        // 当为空的情况
        if (head == null ){
            return false;
        }
        if (head.next == null){
            return true;
        }
        if (head.val == head.next.val && head.next.next==null){
            return true;
        }
        if (head.val != head.next.val && head.next.next==null){
            return false;
        }
        // 双指针 fast和slow
        ListNode fast=head.next, slow=head, second;
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
        fast = head;
        while (fast != null){
            // 考虑奇数情况
            if (pre == null){
                return true;
            }
            if (fast.val != pre.val){
                return false;
            }
            fast = fast.next;
            pre = pre.next;
        }
        return true;
    }
    public static void main(String[] args){
        int[] nums = {1, 0,1};
        ListNode head = new ListNode(nums);
        isPalindrome(head);
    }
}
