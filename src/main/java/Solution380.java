import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> arr;
    Random random;


    public RandomizedSet() {
        this.map = new HashMap<>();
        this.arr = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = arr.size() - 1;
        arr.add(index, val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastIndex = arr.size() - 1;
        int lastVal = arr.get(lastIndex);

        map.remove(val);
        map.put(lastVal, index);
        arr.set(index, lastVal);
        arr.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }
}