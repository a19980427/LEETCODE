import java.util.*;

public class Solution819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase(Locale.ROOT);

        paragraph = paragraph.replace('!', ' ').replace('?', ' ').replace('\'', ' ').replace(',', ' ').replace(';', ' ').replace('.', ' ');

        final String[] words = paragraph.split(" ");

        Map<String, Integer> countMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                int count = countMap.getOrDefault(word, 0);
                countMap.put(word, count + 1);
            }
        }

        Set<String> set = new HashSet<>(Arrays.asList(banned));

        int maxCount = -1;
        String res = "";


        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (!set.contains(entry.getKey()) && maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        new Solution819().mostCommonWord(paragraph, banned);
    }
}
