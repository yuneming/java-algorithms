package newcoder.offer;

import leetcode.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Iterator;

public class DeleteLinkedListDuplicationNode18bytwo {
    public ListNode deleteDuplication(ListNode pHead)
    {
        HashSet<Integer> res = new HashSet<>();
        // 记录重复的值，在新建链表时重复的值均不插入
        HashSet<Integer> duplication = new HashSet<>();
        ListNode p = pHead;
        while (p != null) {
            if (!res.contains(p.val)){
                res.add(p.val);
            }else {
                duplication.add(p.val);
            }
            p = p.next;
        }
        ListNode head = new ListNode(0);
        p = head;
        for (Object obj : res) {
            int tempInt = (Integer)obj;
            if (!duplication.contains(tempInt)) {
                ListNode tempNode = new ListNode(tempInt);
                p.next = tempNode;
                p = tempNode;
            }

        }
        return head.next;

    }
    //定义三个结点 pre、h、post，分别表示前驱、当前和后继。 然后扫描整个链表：

//    如果h.val 不等于 post.val，那么pre、h、post依次向后移动一位
//    反之，post不断后移，直到遇到val不相等的结点
    public ListNode deleteDuplication1(ListNode pHead) {
        ListNode h = pHead, pre = new ListNode(0);
        pre.next = h;
        ListNode post = null;

        while(h != null && (post = h.next) != null) {

            if(h.val != post.val) { // 如果不相等，pre、h、post就依次向后移动一位
                pre = h;
            }else { // 如果相等，
                while(post != null && h.val == post.val) { // post 不断向后移动
                    post = post.next;
                }
                if(pre.next == pHead) { // 如果是从头结点开始就一直重复
                    pHead = post; // 注意，如果从头结点就开始重复，需要修改head
                }
                pre.next = post;
            }
            h = post;
        }
        return pHead;
    }
}
