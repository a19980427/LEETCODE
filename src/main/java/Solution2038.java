import java.util.ArrayList;
import java.util.Stack;

public class Solution2038 {
    public boolean winnerOfGame(String colors) {
        ArrayList<Integer> cntA = new ArrayList<>();
        ArrayList<Integer> cntB = new ArrayList<>();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < colors.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(colors.charAt(i));
            } else {
                char topChar = stack.peek();
                char curChar = colors.charAt(i);
                if (topChar != curChar) {
                    int cnt = stack.size();
                    stack.clear();
                    if (topChar == 'A') {
                        cntA.add(cnt);
                    } else {
                        cntB.add(cnt);
                    }
                }
                stack.push(curChar);
            }
        }

        if (!stack.isEmpty()) {
            char topChar = stack.peek();
            int cnt = stack.size();
            stack.clear();
            if (topChar == 'A') {
                cntA.add(cnt);
            } else {
                cntB.add(cnt);
            }
        }


        System.out.println(cntA);
        System.out.println(cntB);

        int a = 0;
        int b = 0;
        for (Integer integer : cntA) {
            a += Math.max(0, integer - 2);
        }
        for (Integer integer : cntB) {
            b += Math.max(0, integer - 2);
        }
        return a > b;
    }


    public static void main(String[] args) {
        String colors = "AAABABB";
        new Solution2038().winnerOfGame(colors);
    }
}