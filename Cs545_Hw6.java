import javax.jws.soap.SOAPBinding;
import java.util.Iterator;
import java.util.LinkedList;

public class Cs545_Hw6 {

    /**
     * Problem 1:
     * Show the array after each pass of Insertion Sort (after placing each element from the unsorted
     * part of the list into the sorted part of the list). Underline the sorted part of the list.
     * The first pass has already been done for you. (1.5pt)
     */
    public static void insertion(int[] array) {
        print(array);
        for(int i = 1; i < array.length; i++) {

            int curr = array[i];
            int j = i;
            while(j >= 1 && array[j - 1] > curr) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = curr;
            print(array);
        }
    }

    public static void print(int[] array) {
        for(int elem: array) {
            System.out.print(elem + " ");
        }
        System.out.print("\n");
    }

    /**
     * Problem 2: Show the array after each pass of Bubble Sort (after bubbling up the current smallest
     * element to the front of the array). The result after the first pass (after bubbling up 3) is shown
     * below. Show the remaining passes. (1.5pt)
     */
    public static void bubbleSort(int[] array) {
        print(array);
        for(int i = 0; i < array.length; i++) {
            for(int j = array.length - 1; j > i; j--) {
                if(array[j - 1] > array[j]) {
                    swap(array, j, j -1);
                }
            }
            print(array);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Problem 3: Show intermediate steps of sorting the array with Merge Sort. Show the result after each
     * recursive call to the merge sort routine. (1.5 pt)
     */

    public static int[] mergeSort(int[] array) {
        if(array.length < 2) return array;
        int mid = array.length / 2;
        int[] a1 = new int[mid];
        int[] a2 = new int[array.length - mid];
        for(int i = 0; i  < mid; i++) {
            a1[i] = array[i];
            a2[i] = array[mid + i];
        }


        //When array.length is a odd number, the last elem of a2 is 0
        a2[a2.length - 1] = array[array.length - 1];
//        System.out.print("a1 is : ");
//        print(a1);
//        System.out.print("a2 is : ");
//        print(a2);
        return merge(mergeSort(a1), mergeSort(a2));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
                System.out.println("i = " + i);
            } else {
                res[k++] = arr2[j++];
            }
        }
        while(i < arr1.length) {
            System.out.println(arr1.length + " i = " + i);
            res[k++] = arr1[i++];
        }
        while(j < arr2.length) {
            System.out.println(arr1.length + " j = " + j);
            res[k++] = arr2[j++];
        }
//        System.out.print("res is: ");
//        print(res);
//        System.out.print("arr1 is : ");
//        print(arr1);
//        System.out.print("arr2 is : ");
        print(arr2);
        return res;
    }


    /**
     * Problem 4: Show intermediate steps of sorting the same array with Quick Sort. Show the result after
     * picking a pivot for each sublist and arranging the list in such a way that all elements < pivot are
     * on the left side of the pivot, and all elements >= pivot are on the right. Pick the middle element
     * of a sublist as the pivot. (1.5 pt)
     */

    /**
     *Pick the middle element as pivot point
     */
    public static void QuickSort(int[] arr) {
        QuickSort(arr, 0, arr.length - 1);
    }

    public static void QuickSort(int[] arr, int start, int end) {
        System.out.println("h");
        if(start >= end) return;
        int i = start;
        int j = end;
        int mid = (i + j) / 2;
        //Store the pivot point's value
        int pivot = arr[mid];
        System.out.println("pivot = " + pivot);
        //Swap the elements of index mid and j
        swap(arr, mid, j);
        j--;
        while(i <= j) {
            //Note the i <= j should come first to check the index ot of bound
            for(; i <= j && arr[i] < pivot; i++);
            for(; i <= j && arr[j] > pivot; j--);

            //After moving the i and j, if i still smaller or equals to j call swap, otherwise break the loop
            if(i <= j) {
                swap(arr, i, j);
            } else {
                break;
            }
        }
        swap(arr, i, end);
        System.out.println("Quick sort step: ***");
        print(arr);
        //Sort the left part of the pivot point
        QuickSort(arr, start, i - 1);
        //Sort the right part of the pivot point
        QuickSort(arr, i + 1, end);
    }

    /**Problem 5: Show the array after each pass of Heap Sort (using a max heap, and sorting in-place).
     * A pass corresponds to removing the current largest element from the heap, placing it in the correct
     * place in the array, and fixing the heap. (1.5 pt)
     * @param array
     */
    public static void heapSort(int[] array) {
        //Build a max heap
        buildMaxHeap(array);
        System.out.println("The heap is: ");
        print(array);
        for(int size = array.length; size > 0; ) {
            //Move the current root to end
            swap(array, 0, size - 1);
            System.out.println(array.length - size + 1 + "th swap: ");
            print(array);
            //Update the size
            size--;
            pushDown(array, size,0);
            System.out.println(array.length - size + 1 + "th push down: ");
            print(array);
        }
    }

    public static void buildMaxHeap(int[] array) {
        for(int i = array.length / 2 - 1; i >= 0; i--) {
            pushDown(array, array.length, i);
        }
    }

    public static void pushDown(int[] array, int size, int i) {
        int largest = i;
        int l = i * 2; //Left child = i * 2
        int r = i * 2 +1; //Right = i * 2 + 1
        if(l < size && array[largest] < array[l]) {
            largest = l;
        }
        if(r < size && array[largest] < array[r]) {
            largest = r;
        }
        if(i != largest) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            pushDown(array, size, largest);
        }
    }

    public static void zeroFront(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            for(; i < array.length && array[i] == 0; i++);
            for(; j >= 0 && array[j] == 1; j--);
            if(i >= j) break;
            swap(array, i, j);
        }
    }

    public static void zot(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            for(; i < array.length && array[i] == 0; i++);
            for(; j >= 0 && array[j] == 1; j--);
            if(i >= j) break;
            swap(array, i, j);
        }
        j = array.length - 1;
        while(i < j) {
            for(; i < array.length && array[i] == 1; i++);
            for(; j >= 0 && array[j] == 2; j--);
            if(i >= j) break;
            swap(array, i, j);
        }
    }

    public static void countingSort(int[] array, int low, int high) {
        int[] count = new int[high - low + 1];
        for(int i = 0; i < array.length; i++) {
            count[array[i]]++;

        }
        System.out.println(count[0] + "*******");
        int k = 0;
        for(int i = 0; i < count.length; i++) {
            for(int j = 0; j < count[i]; j++) {
                array[k] = i + low;
                k++;
            }
        }
    }

    private class Elem {

    }

    public static void binSort(Elem[] arr, int maxVal) {
        LinkedList<Elem>[] llists = new LinkedList[maxVal + 1];
        for(int i = 0; i <= maxVal; i++) {

        }
        for(int i = 0; i < arr.length; i++) {

        }
        int k = 0;
        //Put it back to array:
        for(int i = 0; i <= maxVal; i++) {
            Iterator<Elem> it = llists[i].iterator();
            while(it.hasNext()) {
                Elem elem = it.next();
                arr[k] = elem;
                k++;
            }
        }

    }

    public static int[] createArray() {
        int[] array = new int[13];
        array[0] = 17;
        array[1] = 10;
        array[2] = 15;
        array[3] = 13;
        array[4] = 4;
        array[5] = 12;
        array[6] = 7;
        array[7] = 9;
        array[8] = 16;
        array[9] = 8;
        array[10] = 5;
        array[11] = 14;
        array[12] = 3;
        return array;
    }


    /**
     * Problem 5: Show the array after each pass of Heap Sort (using a max heap, and sorting in-place). A
     * pass corresponds to removing the current largest element from the heap, placing it in the correct
     * place in the array, and fixing the heap. (1.5 pt)
     */

    public static void main(String[] args) {
        int[] array = createArray();
        insertion(array);

        System.out.println("Do the bubble sort**********");
        array = createArray();
        bubbleSort(array);

        System.out.println("Do the merge sort**********");
        array = createArray();
        System.out.println("Original array: ");
        print(array);
        array = mergeSort(array);
        System.out.println("Merge sorted array: ");
        print(array);

        System.out.println("Do the Quick sort**********");
        array = createArray();
        System.out.println("Original array: ");
        print(array);
        QuickSort(array);
        System.out.println("Quick sorted array: ");
        print(array);
        System.out.println("Test zeroFirst**************");
        int[] arr = new int[5];
        arr[1] = 1;
        arr[3] = 1;
        print(arr);
        System.out.println("After: ");
        zeroFront(arr);
        print(arr);
        System.out.println("Test zot **************");
        arr = new int[5];
        arr[1] = 1;
        arr[3] = 1;
        arr[0] = 2;
        print(arr);
        System.out.println("After: ");
        zot(arr);
        print(arr);
        System.out.println("Test counting sort **************");
        arr = new int[5];
        arr[1] = 1;
        arr[3] = 1;
        arr[0] = 2;
        print(arr);
        System.out.println("After sorted ***********");
        countingSort(arr, 0, 3);
        print(arr);

        System.out.println("Test heap sort **************");
        arr = createArray();
        print(arr);
        heapSort(arr);
        System.out.println("After sorted ***********");
        print(arr);
    }

}
