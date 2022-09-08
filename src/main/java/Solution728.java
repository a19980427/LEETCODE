import java.util.ArrayList;
import java.util.List;

class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        A:
        for (int num = left; num <= right; num++) {
            String strNum = String.valueOf(num);
            for (int i = 0; i < strNum.length(); i++) {
                int integer = strNum.charAt(i) - '0';
                if (integer == 0 || num % integer != 0) {
                    continue A;
                }
            }
            res.add(num);
        }
        return res;
    }
}