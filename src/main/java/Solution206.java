import TempClass.ListNode;

/**
 * @author qihang
 * @create 2022-10-12 下午  07:17
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return nextNode;
    }
}
