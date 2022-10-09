import TempClass.ListNode;

/**
 * @author qihang
 * @create 2022-10-09 下午  12:01
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;

        ListNode pre = virtualNode;
        ListNode next = head;
        while (next != null) {
            if (next.val == val) {
                pre.next = next.next;
                next = next.next;
            } else {
                pre = next;
                next = next.next;
            }
        }
        return virtualNode.next;
    }
}
