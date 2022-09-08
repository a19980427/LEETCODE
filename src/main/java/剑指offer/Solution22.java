package 剑指offer;

import TempClass.ListNode;

/**
 * @author qihang
 * @create 2022-08-24 上午  11:26
 */
public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int temp = k;

        ListNode q = head;
        ListNode p = head;

        while (temp > 0) {
            q = q.next;
            temp--;
        }

        while (q != null) {
            q = q.next;
            p = p.next;
        }
        return p;
    }
}