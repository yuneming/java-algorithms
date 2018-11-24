package leetcode.LinkedList;

import java.util.Stack;

/**
 * leetcode 25
 */
public class ReverseNodesKGroup {
    /**
     * 利用栈结构+递归解决问题
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode temp = head;
        for(int i = 0; i < k ; i++){
            if(head != null){
                st.push(head);
            }else{
                return temp;
            }
            head = head.next;
        }

        ListNode first = st.pop();
        ListNode res = first;
        for(int i = 0; i<k-1; i++){
            first.next = st.pop();
            first = first.next;
        }
        first.next = reverseKGroup(head,k);
        return res;
    }
}
