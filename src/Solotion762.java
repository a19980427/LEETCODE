

public class Solotion762 {

    static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19,};

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            final int count = Integer.bitCount(i);
            for (int prime : primes) {
                if (count == prime) {
                    res += 1;
                }
            }
        }
        return res;
    }


}
