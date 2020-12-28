package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
 * such that i < j < k and nums[i] < nums[k] < nums[j].
 */
public class Pattern132 {

    public boolean mySolutionFind132pattern(int[] nums) {
        if(nums ==null || nums.length <3) return false;

        for(int k=nums.length -1; k>=0; k--) {
            int j = k-1;
            int i = 0;

            while(i<j) {
                if(nums[j] > nums[k] && nums[i] < nums[k]) return true;

                if(nums[j] <= nums[k]) {
                    j--;
                }

                if(nums[i] >= nums[k]) {
                    i++;
                }
            }
        }

        return false;
    }

    public boolean solution2(int[] nums) {
        int min_i = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length - 1; j++) {
            min_i = Math.min(min_i, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && min_i < nums[k])
                    return true;
            }
        }

        return false;
    }

    /**
     * use stack
     * Time complexity : O(n), Space complexity : O(n)
     * @param nums
     * @return
     */
    public boolean solution3find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack< Integer > stack = new Stack < > ();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    /**
     * binary search
     * Time complexity : O(nlogn),  Space complexity : O(n)
     * @param nums
     * @return
     */
    public boolean solution4find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1, k = nums.length; j >= 0; j--) {
            if (nums[j] > min[j]) {
                k = Arrays.binarySearch(nums, k, nums.length, min[j] + 1);
                if (k < 0)
                    k = -1 - k;
                if (k < nums.length && nums[k] < nums[j])
                    return true;
                nums[--k] = nums[j];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Pattern132 runClass = new Pattern132();

//        int[] nums1 = {1,2,3,4};
//        boolean result1 = runClass.mySolutionFind132pattern(nums1);
//        System.out.println(String.format("result is %b: ", result1));

//        int[] nums2 = {6,12,3,4,6,11,20};
//        boolean result2 = runClass.solution4find132pattern(nums2);
//        System.out.println(String.format("result is %b: ", result2));

        int[] nums3 = {6,12,10,30,20,11,9};
        boolean result2 = runClass.solution4find132pattern(nums3);
        System.out.println(String.format("result is %b: ", result2));

    }
}
