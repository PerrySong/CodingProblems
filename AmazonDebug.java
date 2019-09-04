import java.util.*;


public class AmazonDebug {
    public AmazonDebug(){

    }

    public boolean checkPalindrome(int num){
        int result = 0;
        int remainder;
        int temp = num;
        while(num != 0){
            remainder = num % 10;
            result = remainder + result * 10;
            num = num / 10;
        }

        // TODO: return (result == temp)
        return (result == num);
    }

    public int countElement(int arr[], int n){
        int count = 0, len = arr.length;
        int doubleN = 2 * n;
        // TODO:
//        for(int i = 0; i < len; i++){
//            if(arr[i] > doubleN) count++;
//        }

        for(int i = 0; i < n;){
            if(arr[i + 1] > doubleN){
                count += 1;
            }
        }
        return count;
    }

    public int distinctElementCount(int size, int[] elements){
        int[] counted = new int[size];
        int count, flag;
        counted[0] = elements[0];
        count = 1;
        for(int i = 0; i < size; i++){
            flag = 0;
            for(int j = 0; j <  count; j ++ ){
                if(elements[i] == counted[j]) {
                    flag = 1;
                }
            }
            // TODO: if(flag == 0)
            if(flag == 1){
                count ++;
                counted[count - 1] = elements[i];
            }
        }
        return count;
    }
    
    public int appearsKTimes(int size, int inputArray[], int k){
        Arrays.sort(inputArray);
        int i = 1, count = 1;
        int element = inputArray[0];
        int res = -1;
        while(i < size){
            if(element == inputArray[i]){
                count ++;
            } else {
                // TODO:
//                if(count == k){
//                    res = element;
//                }
                element = inputArray[i];
                count = 1;
            }
            i++;
        }
        return res;
    }

    public String eliminateVowel(String str){
        String newString = "";
        int i = 0;
        char[] S = str.toCharArray();
        int len = str.length();
        if(len == 0) return "";

        while(i < S.length){
            switch (S[i]){
                default:
                    newString += S[i];
                    // TODO: delete i++   or    add break after i++
                    i++;
                    break;
                case 'a': i ++;
                    break;
                case 'e': i ++;
                    break;
                case 'i': i ++;
                    break;
                case 'o': i ++;
                    break;
                case 'u': i ++;
                    break;
                case 'A': i ++;
                    break;
                case 'E': i ++;
                    break;
                case 'I': i ++;
                    break;
                case 'O': i ++;
                    break;
                case 'U': i ++;
                    break;
            }
        }
        return newString;
    }

    public int checkArmstrong(int num){
        int digitCount = 0, result = 0;
        int temp = num;

        while(temp != 0){
            temp = temp / 10;
            digitCount ++;
        }

        temp = num;
        while(temp != 0){
            int remainder = temp % 10;
            // TODO: result += Math.pow(remainder, digitCount);
            result += Math.pow(result, digitCount);
            temp /= 10;
        }

        if(result == num){
            return 1;
        } else {
            return 0;
        }
    }

    public int medianValue(int size, int[] arr1, int[] arr2){
        int[] arr = new int[2 * size];
        for(int i = 0; i < 2 * size; i++){
            if(i < size){
                arr[i] = arr1[i];
            } else {
                // TODO: arr[i] = arr2[i - size];
                arr[i] = arr2[i];
            }
        }
        Arrays.sort(arr);

        int length = 2 * size;
        int medi = (arr[length / 2 - 1] + arr[length / 2]) / 2;
        return medi;
    }

    public int countDays(int month, int year){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                // TODO: (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)
                if(((year % 4 == 0) ||
                        (year % 100 != 0))
                        || (year % 400 != 0))
                    return 29;
                else
                    return 28;
            default:
                return -1;

        }
    }

    public int countElementRange(int size, int[] inputArray, int low, int high){
        int count = 0;
        for(int i = 0; i < size; i ++){
            // TODO: (inputArray[i] >= low && inputArray[i] <= high)
            if(inputArray[i] >= low || inputArray[i] <= high){
                count ++;
            }
        }
        return count;
    }

    public int countA(String str){
        if(str == null){
            return 0;
        }

        int count = 0;
        for(int i = 0, len = str.length(); i < len; i++){
            char c = str.charAt(i);
            // TODO: (c == 'A' || c == 'a')
            if(c == 'A' && c == 'a'){
                count ++;
            }
        }

        return count;
    }

    public int matrixSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j, sum = 0;
        while(i < m){
            j = 0;
            while(j < n){
                // TODO: put i++ out of the while(j < n)
                sum += matrix[i++][j++];
            }
        }

        return sum;
    }

    public int vowelsString(String inputstr){
        Set<Character> VOWELS = new HashSet<>();
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');

        if(inputstr == null){
            return 0;
        }

        int i = 0, vcount = 0, len = inputstr.length();
        while(i < len){
            if(VOWELS.contains(inputstr.charAt(i))){
                vcount += 1;
                //TODO: move i++ out of the if
                i++;
            }
        }

        // TODO: len / 2
        if(vcount > (len % 2)){
            return 1;
        } else {
            return 0;
        }
    }

    public int getDigitSumParity(int[] arr){
        int min = getMin(arr);
        int result = getSum(min);
        if(result == 0) {
            return 0;
        }


        //TODO: if(result % 2 == 0)
        //TODO: if(result == 0) return 1
        if(result % 2 != 0){
            return 1;
        } else {
            return 0;
        }
    }

    public int getMin(int[] arr){
        if(arr == null || arr.length <= 0){
            throw new IllegalArgumentException(
                    "Input array should contain at least 1 element"
            );
        }
        int min = arr[0];
        for(int i = 1, len = arr.length; i < len; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public int getSum(int num){
        int sum = 0;
        while(num != 0) {
            //TODO: int tem = num % 10
            //TODO: num =  num / 10
            num = num / 10;
            int temp = num % 10;
            sum = sum + temp;
        }
        return sum;
    }

    public int sumDistinc(int size, int[] inputArray){

        //TODO: Arrays.sort(inputArray);
        //TODO: int sum = inputArray[0];
        int sum = inputArray[0];
        Arrays.sort(inputArray);
        int point = inputArray[0];
        for(int i = 1; i < size; i++){
            if(point != inputArray[i]){
                sum += inputArray[i];
                point = inputArray[i];
            }
        }
        return sum;
    }

    public int countProduct(int size, int valueOfK, int[] priceList){
        if(size == 0){
            return 0;
        }
        int j, count = 0;
        //TODO: for(j = 0; j < size; j++)
        for(j = 0; j < valueOfK; j++){
            if(priceList[j] < valueOfK){
                count = count + 1;
            }
        }
        return count;
    }

    public int[] sortArray(int arr[]){
        int len = arr.length;
        int i, j, temp;
        for(i = 0; i <= len - 1; i++){
            for(j = i; j < len; j++){
                temp = 0;
                //TODO: if(arr[i] < arr[j])
                if(arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void printPattern(int n){
        int i, j, print = 1;
        //TODO: add {} to both loop
        for(i = 1; i <= n; i++)
            for (j = 1; j <= 2 * i; j++)
                System.out.print((print));
            System.out.println();

    }

    public int countOccurrence(int arr[], int value){
        int i = 0, count = 0, len = arr.length;
        while(i <  len){
            if(arr[i] == value){
                count += 1;
                //TODO: move i ++ out
                i++;
            }
        }
        return count;
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        int len = s.length();
        char[] charArray = s.toCharArray();
        int start = 0, length = 1;  //this is for result index
        boolean[][] isPalindrome = new boolean[len][len];

        // if character == charater itself
        for(int i = 0; i < len; i++){
            isPalindrome[i][i] = true;
        }

        // substring size = 2
        // if character == next character
        for(int i = 0; i < len - 1; i++){
            if(charArray[i] == charArray[i + 1]){
                isPalindrome[i][i + 1] = true;
                start = i;
                length = 2;
            }

        }

        for(int i = 3; i <= len; i ++){  // i -> current str length
            for(int j = 0; j + i - 1 < len; j ++){  // j -> index start with 0
                if(charArray[j] == charArray[j + i -1] && isPalindrome[j + 1][j + i - 2] == true){
                    isPalindrome[j][j + i - 1] = true;
                    start = j;
                    length = i;
                }

            }
        }

        return s.substring(start, start + length);

    }

}