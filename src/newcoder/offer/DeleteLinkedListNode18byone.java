package newcoder.offer;

import leetcode.LinkedList.ListNode;

public class DeleteLinkedListNode18byone {
    public ListNode deleteNode(ListNode head, ListNode toDelete) {
        if (head == null || toDelete == null) {
            return null;
        }
        if (toDelete.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = toDelete.next;
            toDelete.val = next.val;
            toDelete.next = next.next;
        }else {
            if (head == toDelete) {
                // 只有一个节点
                head = null;
            }
            else {
                ListNode cur = head;
                while (cur.next != toDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;


    }
}
