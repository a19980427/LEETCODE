package 剑指offer;

/**
 * @Author: qihang
 * @Date: 2022/06/30/上午  10:56
 * @Description:
 */
public class Solution05 {
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                sb.append(ch == ' ' ? "%20" : ch);
            }
            return sb.toString();
        }
    }
}
