package 剑指offer;

import java.util.Stack;

/**
 * @author qihang
 * @create 2022-08-22 下午  04:51
 */
public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped == null || popped.length <= 1) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int curIndex = 0;
        for (int pushElem : pushed) {
            stack.push(pushElem);
            while (!stack.isEmpty() && stack.peek() == popped[curIndex]) {
                stack.pop();
                curIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {0, 2, 1};
        int[] popped = {0, 1, 2};
        new Solution31().validateStackSequences(pushed, popped);
    }
}