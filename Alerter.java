public class Alerter {


    public static boolean alert(int[] input, int wSize, double allowedIncrased) {

        boolean[] noalert = new boolean[input.length];
        double curSum = 0;
        for (int i = 0; i < wSize; i++) {
            curSum += input[i];
        }

        int start = 0, end = wSize;
        while (end <= input.length) {
            for (int i = start; i < end; i++) {
                noalert[i] |= input[i] * wSize <= curSum * allowedIncrased;
//                System.out.println(i);
//                if (i == 4)
//                    System.out.println("total " + input[i] * wSize  + " sum " + curSum * allowedIncrased);
            }
//            System.out.println(start);
            if (!noalert[start]) return true;
            if (end == input.length) break;
            curSum -= input[start];
            curSum += input[end];
            start++;
            end++;
        }

        while (start < input.length) {
//            System.out.println(start);
//            System.out.println(noalert[start]);
            if (!noalert[start++]) return true;

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(alert(new int[] {1, 2, 100, 2, 2}, 3, 1.5));
        System.out.println(alert(new int[] {1, 2, 4, 2, 2}, 3, 2));
        System.out.println(alert(new int[] {1, 2, 100, 2, 2}, 2, 2.5));
    }
}
