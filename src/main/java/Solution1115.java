import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author qihang
 * @create 2022-10-09 下午  06:38
 */
public class Solution1115 {

}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private AtomicBoolean flag = new AtomicBoolean(false);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (flag) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (flag.get()) {
                    flag.wait();
                }
                printFoo.run();
                flag.set(true);
                flag.notify();
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (flag) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                if (!flag.get()) {
                    flag.wait();
                }
                printBar.run();
                flag.set(false);
                flag.notify();
            }
        }
    }
}