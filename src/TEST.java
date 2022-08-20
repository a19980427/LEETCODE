import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: qihang
 * @Date: 2022/06/27/下午  10:21
 * @Description:
 */
public class TEST {

    public static void main(String[] args) {
        People qihang =  new People("qihang", "1");
        People qihang1 = new People("qihang", "2");
        People qihang2 = new People("qihang", "3");
        People qihang3 = new People("qi", "2");
        People qihang4 = new People("qih", "2");

        List<People> list = new ArrayList<>();
        list.add(qihang);
        list.add(qihang1);
        list.add(qihang2);
        list.add(qihang3);
        list.add(qihang4);

        Map<String, People> collect = list.stream()
                .collect(Collectors
                        .toMap(People::getName, Function.identity()));
        System.out.println(collect);
    }


}

