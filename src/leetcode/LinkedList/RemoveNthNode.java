package leetcode.LinkedList;

/**
 * leetcode 19
 */
public class RemoveNthNode {
    /**
     * 先记录链表的总长度
     * 需要对链表进行俩次遍历
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        for(ListNode cur = dummyHead.next ; cur != null ; cur = cur.next)
            length ++;

        int k = length - n;
        assert k >= 0;
        ListNode cur = dummyHead;
        for(int i = 0 ; i < k ; i ++)
            cur = cur.next;

        cur.next = cur.next.next;

        return dummyHead.next;



    }

    /**
     * 使用双指针，对链表只遍历一遍
     */
    public ListNode removeNthFromEndII(ListNode head, int n){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n+1; i++){
            assert q != null;
            q = q.next;
        }
        while (q != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummyHead.next;

    }
}
