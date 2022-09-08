package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihang
 * @create 2022-08-30 上午  10:42
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }

    public static void main(String[] args) {
        String s = new Offer45().minNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
    }

}
