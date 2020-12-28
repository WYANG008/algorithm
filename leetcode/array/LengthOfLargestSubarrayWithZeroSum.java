package array;

import java.util.HashMap;

/**
 * URL: https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 * Given an array of integers, find the length of the longest sub-array with sum equals to 0.
 */
public class LengthOfLargestSubarrayWithZeroSum {

    public int mySolution(int[] arr){

        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            sum[i] = sum[i-1] + arr[i];
        }

        int maxLen = 0;


        for(int j = 0; j<arr.length; j++) {


            if(sum[j]==0) {
                maxLen = Math.max(maxLen, j+1);
                continue;
            }


            if(arr[j]==0) maxLen = Math.max(maxLen, 1);

            int k = arr.length -1;

            while(k> j) {

               if(sum[k]==sum[j]) {
                   maxLen = Math.max(maxLen, k-j);
                   break;
               }

               k--;
            }
        }
        return maxLen;
    }

    /**
     *  The sum-index pair will be stored in a hash-map.
     *  A Hash map allows insertion and deletion of key-value pair in constant time.
     *  Therefore, the time complexity remains unaffected.
     *  So, if the same value appears twice in the array, it will be guaranteed that the particular array will be a zero-sum sub-array.
     * @param arr
     * @return
     */
    public int officialSolution(int[] arr) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i + 1;

            // Look this sum in hash table
            Integer prev_i = hM.get(sum);

            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else // Else put this sum in hash table
                hM.put(sum, i);
        }

        return max_len;
    }

    public static void main(String[] args) {
        LengthOfLargestSubarrayWithZeroSum runClass = new LengthOfLargestSubarrayWithZeroSum();

        int[] input1 = {15, -2, 2, -8, 1, 7, 10, 23};
        int result1= runClass.mySolution(input1);
        System.out.println(String.format("result is %d: ", result1));

        int[] input2 = {1,2,3};
        int result2= runClass.mySolution(input2);
        System.out.println(String.format("result is %d: ", result2));

        int[] input3 = {1,0,3};
        int result3= runClass.mySolution(input3);
        System.out.println(String.format("result is %d: ", result3));


    }
}
