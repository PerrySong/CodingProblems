public class GoogleOA20191004 {

    /**
     * 1 7 8 8
     * 1 6 7 9
     *
     *
     * @param arr1
     * @param arr2
     * @return
     */
    //TODO: FIGURE OUT IT?
    public static int relativeSort(int[] arr1, int[] arr2) {
        int i = 0;

        int[] swap = new int[arr1.length + 1];
        int[] noSwap = new int[arr1.length + 1];
        swap[0] = 1;
        noSwap[0] = 0;

        int res = 0;
        while (i < arr1.length - 1) {
            if ( Math.max(arr1[i], arr2[i]) <= Math.max(arr1[i + 1], arr2[i + 1])
                    || Math.min(arr1[i], arr2[i]) <= Math.min(arr1[i + 1], arr2[i + 1])) {
                return -1;
            }

            if (arr1[i] < arr1[i + 1]) {
                res++;
                swap(arr1, arr2, i + 1);
            }
            i++;
        }
        return Math.min(res, arr1.length - res);
    }

    private static void swap(int[] arr1, int[] arr2, int i) {
        int tmp = arr1[i];
        arr1[i] = arr2[i];
        arr2[i] = tmp;
    }


    public static void main(String[] args) {
        System.out.println(relativeSort(new int[] {2, 1, 6, 5, 8}, new int[] {0, 3, 4, 7, 9})); // 2

        System.out.println(relativeSort(new int[] {3, 1, 6, 5, 8}, new int[] {0, 3, 4, 7, 9})); //
    }
}
