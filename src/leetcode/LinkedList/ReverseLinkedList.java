package leetcode.LinkedList;

/**
 * leetcode 206
 */
public class ReverseLinkedList {
//    public class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }
    public  static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
