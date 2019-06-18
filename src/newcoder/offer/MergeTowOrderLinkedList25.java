package newcoder.offer;

import leetcode.LinkedList.ListNode;

public class MergeTowOrderLinkedList25 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
//                p = p.next;
                list1 = list1.next;
            }
//            else {
//                p.next = list2;
////                p = p.next;
//                list2 = list2.next;
//            }
            // 不能用俩个if来判断，因为前面一个if如果匹配了，list1已经改变了，
            // 所以后面一个if可能会匹配上
            if (list1.val > list2.val) {
                p.next = list2;
//                p = p.next;
                list2 = list2.next;
            }
//            if (list1.val <= list2.val) {
//                p.next = list1;
//                list1 = list1.next;
//            } else {
//                p.next = list2;
//                list2 = list2.next;
//            }
            p = p.next;
        }
//        while (list1 != null){
//            p.next = list1;
//            p = p.next;
//            list1 = list1.next;
//        }
//        while (list2 != null) {
//            p.next = list2;
//            p = p.next;
//            list2 = list2.next;
//        }
        if (list1 != null)
            p.next = list1;
        if (list2 != null)
            p.next = list2;
        return head.next;


    }
}
