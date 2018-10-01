import java.util.Arrays;

public class FriendCircles {
    /**
         There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

         Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

         Example 1:
         Input:
         [[1,1,0],
         [1,1,0],
         [0,0,1]]
         Output: 2
         Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
         The 2nd student himself is in a friend circle. So return 2.
         Example 2:
         Input:
         [[1,1,0],
         [1,1,1],
         [0,1,1]]
         Output: 1
         Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
         so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
         Note:
         N is in range [1,200].
         M[i][i] = 1 for all students.
         If M[i][j] = 1, then M[j][i] = 1.
     */

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int size = M.length;
        int[] root = new int[size];
        Arrays.fill(root, -1);

        for (int i = 0; i < size; i++) {
            for (int j = 0 ; j < size; j++) {
                if (M[i][j] == 1)
                    union(root, i, j);
            }
        }

        int res = 0;
        for (int num : root) {
            if (num < 0)
                res++;
        }
        return res;
    }

    private void union(int[] root, int i, int j) {
        int iRoot = root(root, i), jRoot = root(root, j);
        if (iRoot == jRoot) return;
        if (root[iRoot] == root[jRoot]) {
            root[iRoot] -= 1;
            root[jRoot] = iRoot;
        }
        if (root[iRoot] < root[jRoot]) { //Join j to i
            root[jRoot] = iRoot;
        } else {
            root[iRoot] = jRoot;
        }
    }

    private int root(int[] root, int i) {
        while (root[i] >= 0) {
            i = root[i];
        }
        return i;
    }
}
