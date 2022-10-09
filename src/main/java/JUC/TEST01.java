package JUC;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @author qihang
 * @create 2022-09-21 上午  10:29
 */


@Slf4j(topic = "c.Tes01")
public class TEST01 extends Thread {
    private static int flag = 0;
    static ArrayList<Integer> arrayList = new ArrayList<>();


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new TEST01().start();
        while (true) {
            synchronized (arrayList) {
                arrayList.add(0);
                System.out.println("add");
                Thread.sleep(1000);
            }
        }
    }


    @Override
    public void run() {
        synchronized (arrayList) {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(arrayList.size());
            }
        }
    }

}

