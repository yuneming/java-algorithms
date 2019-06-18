package newcoder.offer;

import leetcode.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class PrintLinkedList6 {
    // 使用栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode curNode = new ListNode(0);
        curNode = listNode;
        while (curNode != null) {
            stack.push(curNode.val);
            curNode = curNode.next;

        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;

    }
}
