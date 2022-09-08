public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        char min = letters[0];
        char max = letters[letters.length - 1];

        if (target < min || target >= max) {
            return min;
        }

        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return 'z';
    }
}