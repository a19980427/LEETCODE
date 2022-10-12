import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author qihang
 * @create 2022-10-12 下午  05:01
 */

class CourseNode {
    public int preCourse;
    public CourseNode nextNode;

    public CourseNode(int preCourse, CourseNode nextNode) {
        this.preCourse = preCourse;
        this.nextNode = nextNode;
    }
}

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<CourseNode> graph = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(null);
        }

        //遍历prerequisites,插入节点
        for (int[] prerequisite : prerequisites) {
            int curCourse = prerequisite[0];
            int preCourse = prerequisite[1];
            inDegree[curCourse] += 1;

            CourseNode course = new CourseNode(preCourse, graph.get(curCourse));
            graph.set(curCourse, course);
        }

        Deque<Integer> freeCourses = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                freeCourses.add(i);
            }
        }
        if (freeCourses.size() == 0) {
            return false;
        }
        while (!freeCourses.isEmpty()) {
            Integer freeCourse = freeCourses.remove();
            removePreCourse(inDegree, freeCourses, freeCourse, graph);
        }
        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private void removePreCourse(int[] inDegree, Deque<Integer> freeCourses, int freeCourse, ArrayList<CourseNode> graph) {
        for (int i = 0; i < graph.size(); i++) {
            CourseNode courseNode = graph.get(i);
            while (courseNode != null) {
                if (courseNode.preCourse == freeCourse) {
                    inDegree[i] -= 1;
                    if (inDegree[i] == 0) {
                        freeCourses.add(i);
                    }
                }
                courseNode = courseNode.nextNode;
            }
        }
    }

    private void test() {

    }

    public static void main(String[] args) {
        new Solution207().canFinish(2, new int[][]{{0, 1}});
    }
}
