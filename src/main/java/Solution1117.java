import java.util.concurrent.Semaphore;

/**
 * @author qihang
 * @create 2022-10-09 下午  10:04
 */
public class Solution1117 {
}

class H2O {

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        h.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }
}