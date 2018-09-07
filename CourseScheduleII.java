import java.util.*;

public class CourseScheduleII {
    /**
         There are a total of n courses you have to take, labeled from 0 to n-1.

         Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

         Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

         There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

         Example 1:

         Input: 2, [[1,0]]
         Output: [0,1]
         Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
         course 0. So the correct course order is [0,1] .
         Example 2:

         Input: 4, [[1,0],[2,0],[3,1],[3,2]]
         Output: [0,1,2,3] or [0,2,1,3]
         Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
         courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
         So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
         Note:

         The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
         You may assume that there are no duplicate edges in the input prerequisites.
     */
    // T(n) = O(m * n)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) return new int[0];
        int[] res = new int[numCourses];
        HashMap<Integer, Integer> pres = new HashMap<>();
        HashMap<Integer, List<Integer>> coursesDependOn = new HashMap<>();

        formMap(prerequisites, pres, coursesDependOn);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!pres.containsKey(i)) queue.offer(i);
        }

        int i = 0;
        while (!queue.isEmpty()) {

            int curCourse = queue.poll();
            res[i++] = curCourse;
            List<Integer> dependCourses = coursesDependOn.get(curCourse);

            if (dependCourses == null) continue;
            for (int course : dependCourses) {
                pres.put(course, pres.get(course) - 1);
                if (pres.get(course) == 0) queue.offer(course);
            }
        }

        if (numCourses > i) return new int[0];
        return res;
    }


    private void formMap(int[][] prerequisites, HashMap<Integer, Integer> pres, HashMap<Integer, List<Integer>> coursesDependOn) {
        for (int[] preReq : prerequisites) {
            //Assume prerequisites does not have duplicate elements
            if (!coursesDependOn.containsKey(preReq[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(preReq[0]);
                coursesDependOn.put(preReq[1], list);
            } else {
                coursesDependOn.get(preReq[1]).add(preReq[0]);
            }

            pres.put(preReq[0], pres.getOrDefault(preReq[0], 0) + 1);

        }
    }

    // Neat and clean
    // T(n) = O(m * n)
    // Space = O(n)
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegrees = new int[numCourses];
        //Fill indegrees
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
        }

        //Find the course whose indegrees is 0 and offer to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }

        //Take course and decrement indegrees accordingly
        int course = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            res[course++] = curCourse;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curCourse) {

                    indegrees[prerequisites[i][0]]--;
                    if (indegrees[prerequisites[i][0]] == 0)
                        queue.offer(prerequisites[i][0]);
                }

            }
        }
        if (course != numCourses) return new int[0];
        return res;
    }
}
