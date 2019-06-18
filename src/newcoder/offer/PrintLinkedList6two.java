package newcoder.offer;

import leetcode.LinkedList.ListNode;

import java.util.ArrayList;

public class PrintLinkedList6two {
    // 头插法构建逆序链表
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {


        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;



    }
}
