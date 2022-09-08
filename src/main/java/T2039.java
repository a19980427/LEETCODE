import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionT2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int nodeNums = patience.length;

        boolean[] visited = new boolean[nodeNums];
        Arrays.fill(visited, false);

        int[] distance = new int[nodeNums];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);
        distance[0] = 0;
        int curDistance = 1;

        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            for (int[] edge : edges) {
                for (int i = 0; i < edge.length; i++) {
                    if (edge[i] == head) {
                        int index = i ^ 1;
                        if (!visited[edge[index]]) {
                            visited[edge[index]] = true;
                            distance[edge[index]] = curDistance;
                            queue.add(edge[index]);
                            break;
                        }
                    }
                }
            }
            curDistance += 1;
        }
        int max = Integer.MIN_VALUE;


        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(patience));

        for (int i = 1; i < nodeNums; i++) {
            int pa = patience[i];
            int dis = distance[i];

            int silentTime = 0;
            int oneQuestTime = dis * 2;
            if (oneQuestTime <= pa) {
                silentTime = oneQuestTime + 1;
            } else {
                int cnt = 0;
                while (cnt * pa < oneQuestTime) {
                    cnt += 1;
                }
                silentTime = cnt - 1 + oneQuestTime + 1;
            }
            max = Math.max(max, silentTime);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        int[] patience = {0, 10, 10};


//        int[][] edges = {{0, 1}, {1, 2}};
//        int[] patience = {0, 2, 1};


        new SolutionT2039().networkBecomesIdle(edges, patience);
    }
}

