package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qihang
 * @create 2022-08-30 上午  10:23
 */
public class Offer38 {

    private StringBuilder stringBuilder;
    private Set<String> res;
    private String s;

    private boolean[] choose;

    public String[] permutation(String s) {
        this.stringBuilder = new StringBuilder(s);
        this.res = new HashSet<>();
        this.s = s;
        this.choose = new boolean[s.length()];

        search(0);
        return res.toArray(new String[0]);
    }

    private void search(int index) {
        if (index == s.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!choose[i]) {
                choose[i] = true;
                stringBuilder.setCharAt(index, s.charAt(i));
                search(index + 1);
                choose[i] = false;
            }
        }
    }
}
