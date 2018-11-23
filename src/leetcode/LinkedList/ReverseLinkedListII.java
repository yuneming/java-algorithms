package leetcode.LinkedList;

/**
 * leetcode 92
 */
public class ReverseLinkedListII {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseBetween(ListNode head, int m, int n) {
       ListNode newHead = new ListNode(0);
       newHead.next = head;
       ListNode c = newHead;
       for (int i = 0; i< m-1; i++){
           c = c.next;
       }
       ListNode p = c.next;
        for (int i = 0; i < n-m ;i++){
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = c.next;
            c.next = tmp;
        }
        return newHead.next;
    }
    public ListNode reverseBetweenII(ListNode head, int m, int n){
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m-1; i++){
            prev = prev.next;
        }

        ListNode cur = prev.next;
        ListNode post = cur.next;
        // 使用头插法来将最后一个元素往前插
        for (int i = 0; i < n-m; i++){
            cur.next = post.next;
            post.next = prev.next;
            prev.next = post;
            post = cur.next;
        }
        return dummy.next;
    }
}
