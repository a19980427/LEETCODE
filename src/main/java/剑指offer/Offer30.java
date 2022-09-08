package 剑指offer;

import java.util.LinkedList;

/**
 * @author qihang
 * @create 2022-09-01 上午  11:45
 */
public class Offer30 {

    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int x) {
        if (minStack.size() == 0) {
            minStack.add(x);
        } else {
            minStack.add(Math.min(x, minStack.getLast()));
        }
        stack.add(x);
    }

    public void pop() {
        minStack.removeLast();
        stack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int min() {
        return minStack.getLast();
    }
}
