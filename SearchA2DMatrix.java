public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        //Binary search the row, then Binary search the col
        int start = 0, end = matrix.length - 1;
        //Search row: the under row is greater, the current row is smaller
        int curRow = start + (end - start) / 2;

        while(start <= end) {
            curRow = start + (end - start) / 2;
            if(curRow + 1 >= matrix.length || matrix[curRow][0] <= target && matrix[curRow + 1][0] > target)
                break;
            else if(matrix[curRow][0] > target)
                end = curRow - 1;
            else
                start = curRow + 1;
            
        }
        start = 0;
        end = matrix[0].length - 1;
        int curCol = start + (end + start) / 2;
        while(start <= end) {
            curCol = start + (end - start) / 2;
            if(matrix[curRow][curCol] == target) return true;
            else if(matrix[curRow][curCol] > target)
                end = curCol - 1;
            else
                start = curCol + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix a = new SearchA2DMatrix();
        int[][] matrix = {{1, 3, 5}};
        System.out.println(a.searchMatrix(matrix, 4));
    }
}
