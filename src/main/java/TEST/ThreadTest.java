package TEST;

import java.time.LocalTime;
import java.util.concurrent.Executors;

/**
 * @author qihang
 * @create 2022-09-09 下午  05:56
 */
public class ThreadTest {
    void test01() {

    }

    public static void main(String[] args) {
        Executors.newFixedThreadPool(10);
        Executors.newFixedThreadPool(5);
        LocalTime parse = LocalTime.parse("12:12:22");
        


    }
}

class Singleton {
    private volatile static Singleton uniqueInstance;

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }

            }
        }
        return uniqueInstance;
    }
}
