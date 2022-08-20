package 剑指offer;

import java.util.LinkedList;

/**
 * @Author: qihang
 * @Date: 2022/07/01/上午  10:58
 * @Description:
 */
public class Solution09 {
    class CQueue {

        private LinkedList<Integer> inStack;
        private LinkedList<Integer> outStack;

        public CQueue() {
            inStack = new LinkedList<>();
            outStack = new LinkedList<>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (inStack.size() == 0 && outStack.size() == 0) {
                return -1;
            }

            if (outStack.size() == 0) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }
    }
}
