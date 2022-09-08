import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T720 {
    public String longestWord(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words);
        map.put("", 0);
        for (String word : words) {
            if (map.containsKey(word.substring(0, word.length() - 1))) {
                map.put(word, word.length());
            }
        }
        int max_length = -1;
        String res = "";
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            String word = stringIntegerEntry.getKey();
            if (word.length() > max_length) {
                max_length = word.length();
                res = word;
            } else if (word.length() == max_length && word.compareTo(res) < 0) {
                res = word;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        new T720().longestWord(arr);
    }
}
