public class Solution796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}