public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        for (int i = 0; i < res.length; i++) {
            char cha = s.charAt(i);
            if (cha == c) {
                res[i] = 0;
            } else {
                //left search
                int left = i - 1;
                while (left >= 0 && s.charAt(left) != c) {
                    left -= 1;
                }
                if (left < 0) {
                    left = -1000000;
                }

                //right search
                int right = i + 1;
                while (right < res.length && s.charAt(right) != c) {
                    right += 1;
                }
                if (right >= res.length) {
                    right = 1000000;
                }

                int leftAbs = Math.abs(i - left);
                int rightAbs = Math.abs(right - i);

                res[i] = Math.min(leftAbs, rightAbs);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution821().shortestToChar("abaa", 'b');
    }
}