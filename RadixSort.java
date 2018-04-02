public class RadixSort {

    /** Represents an element in an array. Has key and data */
    public class Elem {
        private int key;
        private Object data;

        public Elem(int key, Object data) {
            this.key = key;
            this.data = data;
        }

        public int key() {
            return key;
        }

        public Object data() {
            return data;
        }

        public String toString() {
            return key + " " + data + "; ";
        }
    }

    /**
     * Sorts using Radix Sort.
     * Assumes the number of digits in each key is the same.
     * @param arr array of elements of type Elem.
     */
    public static void radixSort(Elem[] arr) {
        // First, compute the number of digits in each key
        // Since we assume they all have the same # of digits,
        // it's enough to compute the # of digits in the first key
        if (arr.length == 0)
            return;
        int ndigits = (int) (Math.log10(arr[0].key()) + 1);

        Elem[] temp = new Elem[arr.length];

        int[] count = new int[10]; // count array for counting sort
        for (int i = 0, place = 1; i < ndigits; i++, place *= 10) {
            // place will be 1, then 10, then 100, then 1000, etc.
            // initialize count array
            for (int j = 0; j < 10; j++)
                count[j] = 0;
            // iterate over arr and fill out count array
            for (int j = 0; j < arr.length; j++) {
                int k = (arr[j].key() / place) % 10;
                count[k]++;
            }

            for (int j = 1; j < 10; j++) // modified count array
                count[j] += count[j - 1];

            // result will be in temp
            for (int j = arr.length - 1; j >= 0; j--)
                temp[--count[(arr[j].key() / place) % 10]] = arr[j];

            // copy the result back into arr
            for (int j = 0; j < arr.length; j++)
                arr[j] = temp[j];
        }
    }
}
