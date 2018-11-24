package leetcode.LinkedList;

/**
 * leetcode 237
 */
public class DeleteNodeLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null){
            return;
        }
        // 删除最后一个节点
        if (node.next == null){
            node = null;
            return;
        }
        //把后面一个节点复制给当前节点，然后删除后面的节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
