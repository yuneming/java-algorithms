package newcoder.offer;

import leetcode.LinkedList.ListNode;

public class ReverseLikedList24 {
    public ListNode ReverseList(ListNode head) {

        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;


    }
}
