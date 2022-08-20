import java.util.*;

public class T599 {


    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        int minIndexSum = Integer.MAX_VALUE;
        List<String> res = new LinkedList<>();

        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if (map1.containsKey(s)) {
                int j = map1.get(s);
                if (i + j > minIndexSum) {
                } else if (i + j < minIndexSum) {
                    minIndexSum = i + j;
                    res.clear();
                    res.add(s);
                } else if (i + j == minIndexSum) {
                    res.add(s);
                }
            }
        }
        return res.toArray(new String[0]);

    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        new T599().findRestaurant(list1, list2);

    }
}



