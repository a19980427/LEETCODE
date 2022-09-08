public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        final String s = Integer.toBinaryString(n);

        if (s.length() <= 1) {
            return true;
        }

        char pre = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                return false;
            }
            pre = s.charAt(i);
        }
        return true;
    }
}