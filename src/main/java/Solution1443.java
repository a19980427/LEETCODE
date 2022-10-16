import java.util.*;

/**
 * @author qihang
 * @create 2022-10-16 上午  11:20
 */


// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass
// not pass


public class Solution1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashSet<int[]> hashSet = new HashSet<>();

        HashMap<Integer, int[]> parent = new HashMap<>();
        for (int[] edge : edges) {
            parent.put(edge[1], edge);
        }

        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                findParent(hashSet, parent, i);
            }
        }
        return hashSet.size() * 2;
    }

    private void findParent(HashSet<int[]> hashSet, HashMap<Integer, int[]> parent, int cur) {
        int[] edge = parent.get(cur);
        if (edge != null) {
            hashSet.add(edge);
            findParent(hashSet, parent, edge[0]);
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = new ArrayList<>();
        boolean[] booleans = new boolean[]{false, false, true, false, true, true, false};
        for (boolean aBoolean : booleans) {
            hasApple.add(aBoolean);
        }
        new Solution1443().minTime(n, edges, hasApple);
    }
}
