import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author qihang
 * @create 2022-09-01 下午  05:37
 */
public class Solution394 {
    private int index = 0;
    private Deque<String> strStack = new ArrayDeque<>();
    private Deque<Integer> numStack = new ArrayDeque<>();
    private String s;

    public String decodeString(String s) {
        // todo 做不出来
        if (Objects.isNull(s) || s.length() <= 1) {
            return s;
        }
        this.s = s;
        StringBuilder res = new StringBuilder();
        while (index < s.length()) {
            char curCh = s.charAt(index);
            if (curCh == '[') {
                //获取左括号内的字母
                index++;
                String stringElem = getStringElem();
                strStack.push(stringElem);
            } else if (Character.isAlphabetic(curCh)) {
                res.append(getStringElem());
            } else if (Character.isDigit(curCh)) {
                int numElem = getNumElem();
                numStack.push(numElem);
            } else {
                String popStr = strStack.pop();
                int numElem = numStack.pop();
                String s1 = strMul(popStr, numElem);
                res.append(s1);
                index++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2);
        s2.intern();
        System.out.println(s1 == s2);
        long c = 0xfffL;
        double t = 0.28173d;

    }

    private String getStringElem() {
        int startIndex = index;
        while (index < s.length()) {
            if (!(s.charAt(index) >= 'a' && s.charAt(index) <= 'z')) {
                break;
            }
            index++;
        }
        return s.substring(startIndex, ++index);
    }

    private int getNumElem() {
        int startIndex = index;
        while (index < s.length()) {
            if (!(s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
                break;
            }
            index++;
        }
        return Integer.parseInt(s.substring(startIndex, ++index));
    }

    private String strMul(String str, int times) {
        StringBuilder sb = new StringBuilder(str.length() * times);
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
