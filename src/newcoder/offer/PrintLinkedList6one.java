package newcoder.offer;

import leetcode.LinkedList.ListNode;

import java.util.ArrayList;

public class PrintLinkedList6one {
    // 使用递归
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        res.addAll(printListFromTailToHead(listNode.next));
        res.add(listNode.val);
        return res;



    }
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        ArrayList<Integer> print = new ArrayList<>();
        print = printListFromTailToHead(head);
    }
}
