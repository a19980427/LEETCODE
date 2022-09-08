package TEST;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author qihang
 * @create 2022-09-07 下午  08:19
 */
public class test01 {
    private final Object target;

    public test01(Object target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        return result;

    }
}
