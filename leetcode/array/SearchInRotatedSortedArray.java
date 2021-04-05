package array;

public class SearchInRotatedSortedArray {

    /**
     * mysolution
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;

        while(left <= right) {
            int mid_index = left + (right - left) / 2;

            int mid_value = nums[mid_index];

            if(mid_value == target) {
                return mid_index;
            } else if(mid_value > nums[right]) {


                if(mid_value >target && target >=nums[left]) {
                    right = mid_index -1;
                } else {

                    left = mid_index+1;
                }
            } else if(mid_value <nums[left]) {
                if(mid_value <target && target <=nums[right]) {
                    left = mid_index+1;
                } else {
                    right = mid_index -1;
                }
            } else if(mid_value <= nums[right] && mid_value >= nums[left]) {
                if(target > mid_value ){
                    left = left +1;
                } else {
                    right = right -1;
                }
            }

        }

        return -1;
    }

    /**
     * official solution
     * @param nums
     * @param target
     * @return
     */
    public int officialSolutionsearch(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        SearchInRotatedSortedArray runClass = new SearchInRotatedSortedArray();

        int[] input = {1};
        int target = 0;
        int result = runClass.search(input, target);
        System.out.println(result);
    }
}
