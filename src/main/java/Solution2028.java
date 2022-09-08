import java.util.Arrays;

public class Solution2028 {

    boolean findRes = false;

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int knownSum = Arrays.stream(rolls).sum();
        int m = rolls.length;

        //剩余部分的和需要=unKnownSum
        int unKnownSum = mean * (n + m) - knownSum;

        int[] res = new int[n];

        int min = unKnownSum / n;
        if (unKnownSum > n * 6 || unKnownSum < n) {
            return new int[0];
        }

        Arrays.fill(res, min);
        if (unKnownSum % n != 0) {
            int minus = unKnownSum - min * n;
            for (int i = 0; i < minus; i++) {
                res[i] += 1;
            }
        }
        return res;
    }
}

