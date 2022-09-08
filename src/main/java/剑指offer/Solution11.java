package 剑指offer;

import java.util.Arrays;

/**
 * @Author: qihang
 * @Date: 2022/07/02/上午  10:48
 * @Description:
 */
public class Solution11 {
    class Solution {
        public int minArray(int[] numbers) {
            return Arrays.stream(numbers).min().getAsInt();
        }
    }
}
