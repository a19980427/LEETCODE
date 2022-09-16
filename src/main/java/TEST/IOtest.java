package TEST;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author qihang
 * @create 2022-09-09 下午  01:17
 */
public class IOtest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileOutputStream fileOutputStream = new FileOutputStream("iotest.data");
//        String hello_world = new String("hello world");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(hello_world);
//
        FileInputStream fileInputStream = new FileInputStream("iotest.data");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String o = (String) objectInputStream.readObject();
        System.out.println(o);
    }
}
