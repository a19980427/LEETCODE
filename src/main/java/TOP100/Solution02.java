package TOP100;

import TempClass.ListNode;

/**
 * @Author: qihang
 * @Date: 2022/06/15/下午  04:55
 * @Description:
 */

public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;

        int plus = 0;
        ListNode res = new ListNode(0, null);
        ListNode cur = res;

        while (a != null && b != null) {
            int sum = a.val + b.val + plus;
            int tempVal;
            if (sum > 9) {
                tempVal = sum - 10;
                plus = 1;
            } else {
                tempVal = sum;
                plus = 0;
            }

            cur.next = new ListNode(tempVal, null);
            cur = cur.next;

            a = a.next;
            b = b.next;
        }

        ListNode extra = (a == null ? b : a);
        if (extra != null) {
            cur.next = extra;
            cur = cur.next;
        } else if (plus != 0) {
            cur.next = new ListNode(0, null);
            cur = cur.next;
        }

        ListNode last = null;
        while (cur != null) {
            last = cur;
            int sum = cur.val + plus;
            if (sum > 9) {
                cur.val = sum - 10;
                plus = 1;
            } else {
                cur.val = sum;
                plus = 0;
                break;
            }
            cur = cur.next;
        }

        if (plus != 0) {
            last.next = new ListNode(plus, null);
        }

        return res.next;
    }
}