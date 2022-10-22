import java.util.HashSet;
import java.util.List;

/**
 * @author qihang
 * @create 2022-10-22 下午  12:10
 */
public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        HashSet<String> startSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();

        for (List<String> path : paths) {
            startSet.add(path.get(0));
            endSet.add(path.get(1));
        }

        endSet.removeAll(startSet);
        return endSet.iterator().next();
    }
}
