package THREAD_Test;

/**
 * @author qihang
 * @create 2022-09-20 下午  08:36
 */
public class t2 {
    public static void main(String[] args) throws InterruptedException {

        child child = new child();
        child.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
            if (i == 5) {
                child.join();
            }
        }
         
    }
}


class child extends thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " " + currentThread().getName());
        }
    }
}