package newcoder.offer;

public class FindFirstCommonNode52 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        int cnt1 = 0;
        while (p1 != null) {
            cnt1++;
            p1 = p1.next;
        }
        int cnt2 = 0;
        ListNode p2 = pHead2;
        while (p2 != null) {
            cnt2++;
            p2 = p2.next;
        }
        int cnt = cnt2 > cnt1 ? cnt2-cnt1:cnt1-cnt2;
        if (cnt2 > cnt1) {
            while (cnt-- > 0) {
                pHead2 = pHead2.next;
            }
        }else {
            while (cnt-- > 0) {
                pHead1 = pHead1.next;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;

    }
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2:l1.next;
            l2 = (l2 == null) ? pHead1:l2.next;
        }
        return l1;

    }
}
