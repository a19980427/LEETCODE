package 剑指offer;

/**
 * @author qihang
 * @create 2022-08-28 下午  05:40
 */
public class Offer66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= a[i], i++)       /* 从左往右累乘 */ {
            B[i] = product;
        }
        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--)  /* 从右往左累乘 */ {
            B[i] *= product;
        }
        return B;
    }
}
