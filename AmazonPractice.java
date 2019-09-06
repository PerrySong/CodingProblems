import java.util.ArrayList;
import java.util.List;

public class AmazonPractice {
    public static int[] sortArray(int[] arr) {
        int i, max, location, j, temp, len = arr.length;
        for (i = 0; i < len; i++) {
            max = arr[i];
            location = i;
            for (j = i; j < len; j++) {
                max = arr[j];
                location = j;
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }



    public class ComponentNode {
        public int value;
        public ArrayList<ComponentNode> components;
        public ComponentNode() {
            components = new ArrayList<>();
        }
        public ComponentNode(int numOfLinesChanged) {
            this.value = numOfLinesChanged;
            this.components = new ArrayList<>();
        }
    }

    class ComponentInfo {
        public int totalVal;
        public int children;
        public ComponentNode component;
        public ComponentInfo(int totalVal, int children, ComponentNode component) {
            this.totalVal = totalVal;
            this.children = children;
            this.component = component;
        }
    }

    private ComponentInfo targetNode;
    private double maxAverage;

    public ComponentNode getFastestComponent(ComponentNode rootComponent) {
        if (rootComponent == null || rootComponent.components.size() == 0) return null;
        targetNode = new ComponentInfo(0, 1, null);
        maxAverage = Double.MIN_VALUE;
        maxComponent(rootComponent);
        return targetNode.component;
    }

    private ComponentInfo maxComponent(ComponentNode cur) {
        if (cur.components.size() == 0) {
            return new ComponentInfo(cur.value, 1, cur);
        }

        int curVal = 0;
        int children = 0;

        for (ComponentNode cNode : cur.components) {
            ComponentInfo curInfo = maxComponent(cNode);
            curVal += curInfo.totalVal;
            children += curInfo.children;
        }

        ComponentInfo curInfo = new ComponentInfo(curVal, children, cur);
        double curAverage = ((double)curVal) / children;
        if (curAverage > maxAverage) {
            targetNode = curInfo;
            maxAverage = ((double)curInfo.totalVal)/ curInfo.children;
        }
        return curInfo;

    }




    /**
        Interview prepare
     */

    public static int sum(int[][] m) {
        if (m == null) return 0;
        int len = m.length;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < len; i++) {
            sum1 += m[i][i];
            sum2 += m[i][len - i - 1];
        }
        return Math.abs(sum1 - sum2);
    }


    // New OA

    //lc 240
    static PairInt locationOfTargetValue(int rowCount, int columnCount, List<List<Integer>> matrix, int targetValue) {
        if (rowCount <= 0 || columnCount <= 0 || matrix == null || matrix.get(0) == null) return new PairInt(-1, -1);
        int i = 0, j = columnCount - 1;
        while (i < rowCount && j >= 0) {
            int curVal = matrix.get(i).get(j);
            if (curVal == targetValue) {
                return new PairInt(i, j);
            }
            if (curVal < targetValue) {
                i--;
            } else {
                j++;
            }
        }
        return new PairInt(-1, -1);
    }

    static class PairInt {
        int first, second;
        PairInt() {}
        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
//        AmazonPractice a = new AmazonPractice();
//        System.out.println(sum(new int[][] {{1, 2}, {2, 1}}));

//        List<List<Integer>> matrix = new ArrayList
//        PairInt res = locationOfTargetValue(3, 4, matrix, 3);
    }
}
