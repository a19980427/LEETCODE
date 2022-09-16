package TEST;

import java.util.Scanner;

/**
 * @author qihang
 * @create 2022-09-13 下午  03:43
 */
public class TEST {
    public boolean canJump(int[] A) {
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int j = 1; j < n; j++) {
            //之前的石头
            //假设第j个没有跳过去
            f[j] = false;
            //最后一个石头
            for (int i = 0; i < j; i++) {
                if (f[i] && i + A[i] >= j) {
                    f[j] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new TEST().canJump(arr));
    }
}
