import java.util.HashSet;

public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] stringMaps = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                code.append(getCode(word.charAt(i), stringMaps));
            }
            set.add(code.toString());
        }
        return set.size();
    }

    private String getCode(char ch, String[] stringMaps) {
        int index = ch - 'a';
        return stringMaps[index];
    }
}