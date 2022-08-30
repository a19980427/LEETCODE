package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qihang
 * @create 2022-08-30 下午  08:56
 */
public class Offer46 {

    private Set<String> dict = new HashSet<>();

    private void init() {
        dict.add("10");
        dict.add("11");
        dict.add("12");
        dict.add("13");
        dict.add("14");
        dict.add("15");
        dict.add("16");
        dict.add("17");
        dict.add("18");
        dict.add("19");
        dict.add("20");
        dict.add("21");
        dict.add("22");
        dict.add("23");
        dict.add("24");
        dict.add("25");
    }


    public int translateNum(int num) {
        String s = String.valueOf(num);
        init();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dict.contains(s.substring(i - 2, i)) ? dp[i - 2] + dp[i - 1] : dp[i - 1];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        int i = new Offer46().translateNum(18822);
        System.out.println(i);
    }
}
