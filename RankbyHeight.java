import java.util.Arrays;
import java.util.Comparator;

public class RankbyHeight {

    /**
         说明[5,0]里5是指这个人(假如这个人叫A)的身高,0指的是A这个人前面的 身高>= A 的人的个数。 再比如说[4,4] 假如他叫B,实际上B身高为4, B前面有4个人身高 >= B的身高.
         Input: [[5,0], [4,4], [5,2], [7,0], [7,1], [6,1]]
         Output: [[5,0], [7,0], [5,2], [6,1], [4, 4], [7,1]]
         说出是要把原本不正确的输入数组(int[][]型) 排列成一个符合我上面讲的规则的数组.

     */

    // Assume all persons' height is greater than 0
    public int[][] rankByHeight(int[][] people) {
        if (people == null || people.length == 0 || people[0].length != 2) return null;
        // Bucket sort?
        // Sort
        int[][] res = new int[people.length][2];

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        for (int[] person : people) {
            int rank = -1;
            for (int i = 0; i < res.length; i++) {
                if (res[i][0] == 0) rank++;
                if (rank == person[1]) {
                    res[i] = new int[]{person[0], person[1]};
                    break;
                }
                if (rank >= people.length) return null; // Handle the error for now
            }
        }

        return res;
    }

    public static void main(String[] args) {
        RankbyHeight a = new RankbyHeight();
        int[][] res = a.rankByHeight(new int[][]{{5,0}, {4,4}, {5,2}, {7,0}, {7,1}, {6,1}});
        for (int[] i : res) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
