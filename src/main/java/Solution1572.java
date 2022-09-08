/**
 * @author qihang
 * @create 2022-09-07 下午  12:51
 */
public class Solution1572 {
    public String reorderSpaces(String text) {
        if (text == null || text.length() <= 1) {
            return text;
        }

        int length = text.length();
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                spaceCount++;
            }
        }

        String[] words = text.trim().split("\\s+");
        StringBuilder res = new StringBuilder();

        int fillSpaceCount = (words.length == 1) ? 0 : spaceCount / (words.length - 1);
        StringBuilder fillStr = new StringBuilder();
        for (int i = 0; i < fillSpaceCount; i++) {
            fillStr.append(" ");
        }
        for (int i = 0; i < words.length - 1; i++) {
            res.append(words[i]).append(fillStr);
        }
        res.append(words[words.length - 1]);
        for (int i = 0; i < spaceCount - fillSpaceCount * (words.length - 1); i++) {
            res.append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new Solution1572().reorderSpaces("  this   is  a sentence ");

    }
}
