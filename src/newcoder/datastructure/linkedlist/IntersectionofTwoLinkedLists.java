package newcoder.datastructure.linkedlist;

public class IntersectionofTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
    }
}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        if(headA == null || headB == null) {
            return null;
        }
        if(headA == headB) {
            return headA;
        }
        while (true) {

            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null && p2 == null) {
                return null;
            }
            if (p1 == null) {
                p1 = headB;
            }
            if (p2 == null) {
                p2 = headA;
            }
            if (p1 == p2) {
                break;
            }


        }
        return p1;

    }
}
