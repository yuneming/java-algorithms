package leetcode.LinkedList;

/**
 * leetcode 203
 */
public class RemoveLinkedListEle {
    public ListNode removeElements(ListNode head, int val) {
        // 需要对头结点进行特殊处理
        while (head != null && head.val == val){
            ListNode node = head;
            head = head.next;
        }
        if (head == null){
            return head;
        }
        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 使用虚拟头结点
     */
    public ListNode removeElementsII(ListNode head, int val){
        // 创建虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            }
            else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
