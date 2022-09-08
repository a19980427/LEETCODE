package TEST;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qihang
 * @create 2022-09-07 下午  09:42
 */

interface SmsService {
    String send(String message);
}

class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("HELLO WORLD : " + message);
        return message;
    }
}

//动态代理类
class MyInvocationHandler implements InvocationHandler {
    //需要代理的对象
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---before---");
        Object result = method.invoke(target, args);
        System.out.println("---after---");
        return result;
    }
}

//代理对象的工厂类
class proxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//获取代理对象的类加载器
                target.getClass().getInterfaces(),//获取代理对象实现的接口
                new MyInvocationHandler(target)//获取代理对象的动态代理类
        );
    }
}


public class JDK动态代理 {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsService proxy = (SmsService) proxyFactory.getProxy(smsService);
        proxy.send("java");
    }
}

