import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    /**
     *
         There are a total of n courses you have to take, labeled from 0 to n-1.

         Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

         Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

         Example 1:

         Input: 2, [[1,0]]
         Output: true
         Explanation: There are a total of 2 courses to take.
         To take course 1 you should have finished course 0. So it is possible.
         Example 2:

         Input: 2, [[1,0],[0,1]]
         Output: false
         Explanation: There are a total of 2 courses to take.
         To take course 1 you should have finished course 0, and to take course 0 you should
         also have finished course 1. So it is impossible.
         Note:

         The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
         You may assume that there are no duplicate edges in the input prerequisites.
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int[] precourses = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            precourses[prerequisites[i][0]]++;
        }

        for(int i = 0; i < precourses.length; i++) {
            if(precourses[i] == 0)
                queue.offer(i);
        }
        int finished = queue.size();
        while(!queue.isEmpty()) {
            int course = queue.poll();

            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == course) {
                    precourses[prerequisites[i][0]]--;
                    if(precourses[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                        finished++;
                    }

                }
            }
        }

        return finished == numCourses;

    }

    public static void main(String[] args) {
            int[][] b = {{0,1}};
            CourseSchedule a = new CourseSchedule();
            System.out.println( a.canFinish(2, b));
    }
}
