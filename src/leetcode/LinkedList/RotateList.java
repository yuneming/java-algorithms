package leetcode.LinkedList;

/**
 * leetcode 61
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        //Get the total length
        for (i=0;fast.next!=null;i++)
            fast=fast.next;
        //Get the i-n%i th node
        for (int j=i-k%i;j>0;j--)
            slow=slow.next;
        //Do the rotation
        // 整段的进行移动，不是单个移动
        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4,5};
        ListNode head = new ListNode(nums);
        rotateRight(head,2);
    }
}
