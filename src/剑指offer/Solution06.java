package 剑指offer;

import TempClass.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: qihang
 * @Date: 2022/06/30/上午  11:01
 * @Description:
 */
public class Solution06 {
    class Solution {
        public int[] reversePrint(ListNode head) {

            ArrayList<Integer> list = new ArrayList<>(5000);

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            Collections.reverse(list);
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
