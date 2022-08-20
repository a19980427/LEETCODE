import java.lang.reflect.Method;
import java.util.*;

public class T432 {
    private Map<String, Elem> map;
    private Queue<Elem> max_queue;
    private Queue<Elem> min_queue;

    public T432() {
        map = new HashMap<>();
        max_queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        min_queue = new PriorityQueue<>(Comparator.comparingInt(Elem::getValue));
    }

    public void inc(String key) {
        Elem elem = map.getOrDefault(key, null);
        if (elem == null) {
            elem = new Elem(key, 1);
        } else {
            max_queue.remove(elem);
            min_queue.remove(elem);
            elem.setValue(elem.getValue() + 1);
        }
        //更新排序集合
        max_queue.add(elem);
        min_queue.add(elem);
        //更新字典
        map.put(key, elem);


    }

    public void dec(String key) {
        final Elem elem = map.getOrDefault(key, null);
        if (elem != null) {
            max_queue.remove(elem);
            min_queue.remove(elem);
            elem.setValue(elem.getValue() - 1);
            if (elem.getValue() > 0) {
                max_queue.add(elem);
                min_queue.add(elem);
                map.put(key, elem);
            }
        }
    }

    public String getMaxKey() {
        if (max_queue.size() == 0) {
            return "";
        }
        return max_queue.peek().getKey();
    }

    public String getMinKey() {
        if (min_queue.size() == 0) {
            return "";
        }
        return min_queue.peek().getKey();
    }

    public static void main(String[] args) throws Exception {
        final Class<?> t432 = Class.forName("T432");
        final T432 o = (T432) t432.newInstance();
        //String[] methodNames = {"inc", "inc", "inc", "inc", "inc", "dec", "dec", "getMaxKey", "getMinKey"};
        //String[] params = {"a", "b", "b", "b", "b", "b", "b", "", ""};

        String[] methodNames = {"inc", "inc", "inc", "inc", "inc", "inc", "dec", "dec", "getMinKey", "dec", "getMaxKey", "getMinKey"};
        String[] params = {"a", "b", "b", "c", "c", "c", "b", "b", "", "a", "", ""};

        for (int i = 0; i < methodNames.length; i++) {
            String methodName = methodNames[i];
            String param = params[i];
            Method method = null;
            if (param.equals("")) {
                method = t432.getMethod(methodName);
                method.invoke(o);
            } else {
                method = t432.getMethod(methodName, String.class);
                method.invoke(o, param);
            }
        }

    }
}

class Elem {
    private String key;
    private int value;

    public Elem() {
    }

    public Elem(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("[%s,%s]", key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Elem elem = (Elem) o;
        return value == elem.value && Objects.equals(key, elem.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

