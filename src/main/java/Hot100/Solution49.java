package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author qihang
 * @create 2022-09-16 上午  11:43
 */
public class Solution49 {


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            ArrayList<String> indexList = hashMap.getOrDefault(key, new ArrayList<>());
            indexList.add(str);
            hashMap.put(key, indexList);
        }

        return new ArrayList<>(hashMap.values());
    }
}
