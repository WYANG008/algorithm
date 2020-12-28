package array;


/**
 * Leet Code Problem 209 Medium
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 */
public class MinimumSizeSubarraySum  {

    /**
     * my solution
     * Runtime: 1 ms, faster than 99.90% of Java online submissions for Minimum Size Subarray Sum.
     * Memory Usage: 39 MB, less than 65.42% of Java online submissions for Minimum Size Subarray Sum.
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int i = 0, j =0;
        int currSum = nums[0];
        int minLength = nums.length + 1;
        while ( j < nums.length) {
            if(currSum < s) {
                if(j == nums.length -1) break;
                else {
                    j++;
                    currSum += nums[j];
                }

            } else {

                int length = j-i +1;
                if(length < minLength) minLength = length;
                if(i<j) {


                    currSum -= nums[i];
                    i++;
                } else {
                    return 1;
                }
            }
        }
        return minLength > nums.length ? 0: minLength;
    }

    /**
     * Solution 2 in discussion
     * Runtime: 1 ms, faster than 99.90% of Java online submissions for Minimum Size Subarray Sum.
     * Memory Usage: 38.8 MB, less than 79.60% of Java online submissions for Minimum Size Subarray
     * @param s
     * @param nums
     * @return
     */
    public int S2minSubArrayLen(int s, int[] nums) {

        int si = 0, ei = 0, len = (int)1e8, sum = 0, prefixSum = 0;

        while(ei<nums.length){
            prefixSum += nums[ei++];
            while(prefixSum >=s){
                len = Math.min(len,(ei-si));
                prefixSum -= nums[si++];
            }
        }
        return len == (int)1e8 ? 0 : len;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum runClass = new MinimumSizeSubarraySum();

//        int s1 = 7;
//        int[] nums1 = {2,3,1,2,4,3};
//        int result1 = runClass.minSubArrayLen(s1, nums1);
//        System.out.println(String.format("result is %d: ", result1));

        int s2 = 4;
        int[] nums2 = {1, 4,4};
        int result2 = runClass.minSubArrayLen(s2, nums2);
        System.out.println(String.format("result is %d: ", result2));
    }
}
