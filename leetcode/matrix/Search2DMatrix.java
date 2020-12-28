package matrix;

/**
 * searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class Search2DMatrix {

    /**
     * my solution
     * Runtime: 8 ms, faster than 6.82% of Java online submissions for Search a 2D Matrix
     * Memory Usage: 39.1 MB, less than 7.31% of Java online submissions for Search a 2D Matrix.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int r_first = 0, r_last = matrix.length;

        int r_num = 0;
        while (r_first<r_last) {


            int mid = r_first + (r_last-r_first) / 2;

            if(r_first == mid) {
                r_num = r_first;
                System.out.println(String.format("r_num is %d: ", r_num));
                break;
            }


            int mid_num = matrix[mid][0];

            if(mid_num > target) {
                r_last = mid;
            } else if(mid_num<target) {
                r_first = mid;
            } else {
                return true;
            }


        }

        int c_first = 0, c_last = matrix[r_num].length;
        int c_num = 0;
        while(c_first< c_last) {
            int mid = c_first + (c_last - c_first) /2;

            if(c_first == mid) {
                c_num = c_first;
                break;
            }

            int mid_num = matrix[r_num][mid];

            if(mid_num > target) {
                c_last = mid;
            } else if(mid_num<target) {
                c_first = mid;
            } else {
                return true;
            }
        }



        return matrix[r_num][c_num] == target;
    }

    public boolean discussionSolution3searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;

        int left = 0;
        int col_num = matrix[0].length;
        int row_num = matrix.length;
        int right = col_num*row_num -1;

        while(left <= right) {
            int mid = left + (right-left) /2;
            int mid_element = matrix[mid/col_num][mid%col_num];
            if(mid_element == target) {
                return true;
            } else if(mid_element >target) {
                right = mid -1;
            } else {
                left = mid +1;

            }
        }
        return false;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
     * Memory Usage: 38.7 MB, less than 22.24% of Java online submissions for Search a 2D Matrix.
     * @param matrix
     * @param target
     * @return
     */
    public boolean discussionSolution1SearchMatrix(int[][] matrix, int target) {

        //loop in each row
        for(int i =0; i< matrix.length;i++){
            //if last index value greater than or equal to target execute the block
            if(matrix[i][matrix[i].length-1] >= target){

                //loop from 0th index of that row
                for(int j =0; j< matrix[i].length;j++){

                    //if value matches, return true;
                    if(matrix[i][j]==target) return true;
                }
                //if no value matches in that row, returns false
                return false;
            }
        }

        //if no value matches returns false
        return false;
    }

    public boolean discussionSolution2searchMatrix(int[][] matrix, int target) {
        for(int arr[]: matrix){
            if(BinarySearch(arr, target)){
                return true;
            }
        }
        return false;
    }



    private boolean BinarySearch(int arr[], int target){
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid] > target){
                right--;
            }
            else{
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix runClass = new Search2DMatrix();

        int[][] matrix1 = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target1 = 3;
        boolean result1 = runClass.discussionSolution3searchMatrix(matrix1, target1);
        System.out.println(String.format("result is %b: ", result1));

//        int[][] matrix2 = {{2}};
//        int target2 = 1;
//        boolean result2 = runClass.discussionSolution3searchMatrix(matrix2, target2);
//        System.out.println(String.format("result is %b: ", result2));
    }
}
