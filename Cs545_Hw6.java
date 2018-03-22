public class Cs545_Hw6 {

    /**
     * Problem 1:
     * Show the array after each pass of Insertion Sort (after placing each element from the unsorted
     * part of the list into the sorted part of the list). Underline the sorted part of the list.
     * The first pass has already been done for you. (1.5pt)
     */
    public static void insertion(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i;
            while(j >= 1 && array[j - 1] > curr) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = curr;
        }
    }

    /**
     * Problem 2: Show the array after each pass of Bubble Sort (after bubbling up the current smallest
     * element to the front of the array). The result after the first pass (after bubbling up 3) is shown
     * below. Show the remaining passes. (1.5pt)
     */

    /**
     * Problem 3: Show intermediate steps of sorting the array with Merge Sort. Show the result after each
     * recursive call to the merge sort routine. (1.5 pt)
     */

    /**
     * Problem 4: Show intermediate steps of sorting the same array with Quick Sort. Show the result after
     * picking a pivot for each sublist and arranging the list in such a way that all elements < pivot are
     * on the left side of the pivot, and all elements >= pivot are on the right. Pick the middle element
     * of a sublist as the pivot. (1.5 pt)
     */

    /**
     * Problem 5: Show the array after each pass of Heap Sort (using a max heap, and sorting in-place). A
     * pass corresponds to removing the current largest element from the heap, placing it in the correct
     * place in the array, and fixing the heap. (1.5 pt)
     */

    public static void main(String[] args) {

    }

}
