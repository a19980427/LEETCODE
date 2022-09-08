import java.util.Stack;

class Solution682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String op : ops) {
            try {
                Integer score = Integer.valueOf(op);
                stack.add(score);
            } catch (Exception e) {
                int size = stack.size();
                switch (op) {
                    case "+":
                        int sum = stack.get(size - 1) + stack.get(size - 2);
                        stack.add(sum);
                        break;
                    case "D":
                        stack.add(stack.get(size - 1) * 2);
                        break;
                    case "C":
                        stack.pop();
                }
            }
        }
        int res = 0;

        for (Integer integer : stack) {
            res += integer;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        final int i = new Solution682().calPoints(ops);
    }
}