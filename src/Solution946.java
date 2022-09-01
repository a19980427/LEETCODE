import java.util.ArrayList;

/**
 * @author qihang
 * @create 2022-08-31 上午  11:30
 */
public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popIndex = 0;
        ArrayList<Integer> stack = new ArrayList<>();

        for (int i : pushed) {
            stack.add(i);
            while (!stack.isEmpty() && stack.get(stack.size() - 1) == popped[popIndex]) {
                stack.remove(stack.size() - 1);
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
