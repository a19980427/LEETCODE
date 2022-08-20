public class Solution806 {

    public int[] numberOfLines(int[] widths, String s) {
        final int lineLength = 100;
        int countLine = 1;
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = curLen + charLength(widths, s.charAt(i));
            if (length > lineLength) {
                //换行
                countLine += 1;
                curLen = charLength(widths, s.charAt(i));
            } else {
                curLen = length;
            }
        }
        return new int[]{countLine, curLen};
    }

    private int charLength(int[] widths, char ch) {
        return widths[ch - 'a'];
    }

}