package 剑指offer;

import TempClass.ListNode;

/**
 * @author qihang
 * @create 2022-07-18 下午  04:45
 */
public class Solution18 {
    class Solution {
        //[-3,5,-99]
        public ListNode deleteNode(ListNode head, int val) {
            ListNode p = head;
            if (p == null){
                return null;
            }

            if(p.val == val){
                return p.next;
            }

            while (p.next != null){
                if (p.next.val == val){
                    p.next = p.next.next;
                    break;
                }
                p = p.next;
            }
            return head;
        }
    }
}
