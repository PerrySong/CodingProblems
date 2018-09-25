import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CareerPrepProblems {
    /**
     *
     *
     *   Find the largest sum from the root to the bottom.
     *   From node [i, j], you can only go to node [i + 1, j], [i + 1, j + 1]
     *
     *   10
     *   22 31
     *   97 645 22
     *   81 99 0 271
     *
     */

    /**
     * Questions: can we change the triangle's values?
     *
     * @param triangle
     * @return
     */
    public static int largestSum(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) return 0;
        // We store the current maximum sum from the root node to the current node.

        // Initialization: the left most branch and right most branch can only have one path, so the max sum is fixed
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
        }

        // Current largest sum should be the max sum of parents' + current node value.
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            }
        }

        // Iterate the last level and return the largest sum
        int res = Integer.MIN_VALUE;
        int index = -1;
        for (int j = 0; j < triangle[triangle.length - 1].length; j++) {
            res = Math.max(res, triangle[triangle.length - 1][j]);
        }
        return res;
    }


    /**
     *
     *
     * @param triangle
     * @return
     */
    public static List<Integer> largestSumPath(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) return null;
        // We store the current maximum sum from the root node to the current node.

        // Initialization: the left most branch and right most branch can only have one path, so the max sum is fixed
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
        }

        // Current largest sum should be the max sum of parents' + current node value.
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            }
        }

        // Iterate the last level and return the largest sum
        int maxSum = Integer.MIN_VALUE;
        int index = -1;
        for (int j = 0; j < triangle[triangle.length - 1].length; j++) {
            if (maxSum < triangle[triangle.length - 1][j]) {
                index = j;
                maxSum = triangle[triangle.length - 1][j];
            }
        }

        return trackLargestPath(triangle, index);
    }

    private static List<Integer> trackLargestPath(int[][] sumsTri, int lastIndex) {
        List<Integer> res = new LinkedList<>();
        for (int i = sumsTri.length - 2; i >= 0; i--) {
            res.add(0, lastIndex);
            if (lastIndex != 0) {
                lastIndex = sumsTri[i][lastIndex] > sumsTri[i][lastIndex - 1] ? lastIndex : lastIndex - 1;
            }
        }
        res.add(0, lastIndex);
        return res;
    }

    public static int[][] readTriangle(String fileName) {
        List<List<Integer>> resList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String text;
            int level = 0;
            while ((text = reader.readLine()) != null) {
                List<Integer> curList = new ArrayList<>();
                String[] textArr = text.split("\\s+");
                for (String item : textArr) {
                    curList.add(Integer.valueOf(item));
                }
                resList.add(curList);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int[][] res = new int[resList.size()][resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            for (int j = 0; j <= i; j++) {
                res[i][j] = resList.get(i).get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] triangle = new int[][] {{10}, {22, 31}, {97, 645, 22}, {81, 99, 0, 217}};
        System.out.println(largestSum(triangle));
        triangle = new int[][] {
                {75},
            {95, 64},
                {17, 47, 82},
                    {18, 35, 87, 10},
                        {20, 04, 82, 47, 65},
                            {19, 01, 23, 75, 03, 34},
                                {88, 02, 77, 73, 07, 63, 67},
                                    {99, 65, 04, 28, 06, 16, 70, 92},
                                        {41, 41, 26, 56, 83, 40, 80 ,70, 33},
                                            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                                                {53, 71, 44 ,65, 25, 43, 91, 52, 97, 51, 14},
                                                    {70 ,11, 33, 28 ,77, 73, 17, 78, 39, 68, 17, 57},
                                                        {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                                                            {63, 66 ,04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                                                                {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23}};
        System.out.println(largestSum(triangle));
        triangle = readTriangle("big_triangle.txt");
        System.out.println(largestSum(triangle));
        System.out.println(largestSumPath(triangle));
    }
}
