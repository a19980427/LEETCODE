package THREAD_Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author qihang
 * @create 2022-09-20 上午  11:45
 */
public class tt {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> future = new FutureTask<>(new threadCa());
        new Thread(future).start();
        Integer integer = future.get();
        System.out.println(integer);
    }
}

class threadCa implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 2048;
    }
}


class thread extends Thread {
    @Override
    public void run() {
        System.out.println("hello world");
        System.out.println(Thread.currentThread().getName());
    }

    public void thread(){

    }
}

class threadRu implements Runnable {

    @Override
    public void run() {
        System.out.println("good day ");
    }
}
