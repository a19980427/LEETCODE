package THREAD_Test;

import java.util.concurrent.ExecutionException;

/**
 * @author qihang
 * @create 2022-09-20 下午  03:44
 */
public class Sqare {
    long width;

    Sqare(long i) {
        width = i;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Sqare a, b, c;
        a = new Sqare(42L);
        b = new Sqare(42L);
        c = b;
        long s = 42;
    }
}


