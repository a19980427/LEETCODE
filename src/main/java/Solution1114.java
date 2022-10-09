import java.util.ArrayList;

/**
 * @author qihang
 * @create 2022-10-09 下午  06:26
 */
public class Solution1114 {

}

class Foo {

    private ArrayList<Integer> arrayList = new ArrayList<>();


    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (true) {
            synchronized (arrayList) {
                if (arrayList.size() == 0) {
                    // printFirst.run() outputs "first". Do not change or remove this line.
                    printFirst.run();
                    arrayList.add(0);
                    return;
                }
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            synchronized (arrayList) {
                if (arrayList.size() == 1) {
                    // printSecond.run() outputs "second". Do not change or remove this line.
                    printSecond.run();
                    arrayList.add(0);
                    return;
                }
            }
        }


    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            synchronized (arrayList) {
                if (arrayList.size() == 2) {
                    // printThird.run() outputs "third". Do not change or remove this line.
                    printThird.run();
                    arrayList.add(0);
                    return;
                }
            }
        }


    }
}