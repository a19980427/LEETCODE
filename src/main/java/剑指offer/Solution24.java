package 剑指offer;

import TempClass.ListNode;

/**
 * @author qihang
 * @create 2022-08-24 上午  11:33
 */
public class Solution24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//
//        Stack<ListNode> stack = new Stack<>();
//        ListNode temp = head;
//
//        while (temp != null) {
//            stack.push(temp);
//            temp = temp.next;
//        }
//
//        ListNode newHead = stack.pop();
//        temp = newHead;
//
//        while (!stack.isEmpty()) {
//            temp.next = stack.pop();
//            temp = temp.next;
//        }
//        temp.next = null;
//        return newHead;


        ListNode mid = head.next;
        ListNode pre = head;
        ListNode last = mid.next;

        pre.next = null;

        while (last != null) {
            mid.next = pre;

            pre = mid;
            mid = last;
            last = last.next;
        }

        mid.next = pre;

        return mid;
    }
}