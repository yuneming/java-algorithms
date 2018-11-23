package leetcode.LinkedList;

import java.util.Stack;

/**
 * leetcode 2,445
 */
public class AddTwoNumbers {
    /**
     * 数字逆序存放
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        // 头结点
        ListNode dummy1 = new ListNode(0);
        // 当前结点
        ListNode curr1 = dummy1;
        while (l1!=null || l2 != null || carry!=0){
            int l1Num= 0;
            int l2Num = 0;
            if (l1 != null){
                l1Num = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                l2Num = l2.val;
                l2 = l2.next;
            }
            int total = l1Num+l2Num;
            if (carry ==1){
                total+=1;
                carry = 0;
            }
            if (total>=10){
                total = total%10;
                carry = 1;
            }

            ListNode temp = new ListNode(total);
            curr1.next = temp;
            curr1 = temp;

        }
        return dummy1.next;

    }

    /**
     * 数字顺序存放
     */
    public static ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        // head的下一个结点为curNode
        ListNode curNode = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            // head.val存储进制位，head.val可能为0
            ListNode head = new ListNode(sum / 10);
            // curNode存储结果
            curNode.val = sum % 10;
            head.next = curNode;
            // curNode往前移动，指向head
            curNode = head;
            // 此时sum存储的是进制位
            // 下次计算需要用到
            sum /= 10;
        }
        // 前导0的情况,
        // curNode为head的引用，可能为0
        if (curNode.val == 0)
            curNode = curNode.next;
        return curNode;

    }
    public static void main(String[] args){
        int[] arr1 = {3,4,2};
        int[] arr2 = {4,6,5};
//        int[] arr1 = {2,4,3};
//        int[] arr2 = {5,6,4};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        //long a = 10000000000;
        System.out.println(addTwoNumbersII(l1,l2));


    }
}
