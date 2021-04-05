package array;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianOfTwoSortedArrays {

    /**
     * mysolution
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 81.75%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 28.09%
     * 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m == 0 && n == 0) return 0;

        boolean isEven = ((m + n) & 1) == 0;


        int median_nnm = isEven? (m + n) / 2 : (m + n) / 2 + 1;

        if (m == 0) {
            return isEven ? (double) ((nums2[median_nnm ] + nums2[median_nnm -1 ]))/2 : nums2[median_nnm -1];
        }
        if (n == 0)  {
            return isEven ? (double) (nums1[median_nnm ] + nums1[median_nnm -1 ])/2: nums1[median_nnm -1];
        }

        int total_steps = 0;
        int next_i = 0, next_j = 0;

        int current_val = -1;
        while (next_i < nums1.length && next_j < nums2.length) {
            if (total_steps == median_nnm) {
                if (((m + n) & 1) == 0) {
                    int next_val = nums1[next_i] <= nums2[next_j] ? nums1[next_i] : nums2[next_j];
                    return (double) (current_val + next_val) / 2;
                } else {
                    return current_val;
                }
            }

            if (nums1[next_i] <= nums2[next_j]) {
                current_val = nums1[next_i];
                next_i++;

            } else {
                current_val = nums2[next_j];
                next_j++;

            }

            total_steps++;
        }


        while (next_i < nums1.length) {

            if (total_steps == median_nnm) {
                if (((m + n) & 1) == 0) {
                    int nex_val = nums1[next_i];
                    return (double) (current_val + nex_val) / 2;
                } else {
                    return current_val;
                }
            }

            current_val = nums1[next_i];
            next_i++;

           total_steps++;


        }

        while (next_j < nums2.length) {
            if (total_steps == median_nnm) {
                if (((m + n) & 1) == 0) {
                    int next_val = nums2[next_j];
                    return (double) (current_val + next_val) / 2;
                } else {
                    return current_val;
                }
            }
            current_val = nums2[next_j];
            next_j++;

           total_steps++;


        }


        return 0;
    }

    /**
     * officialSolution 1
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


    public static void main(String[] args) {
        MedianOfTwoSortedArrays runClass = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2,3};

        double res = runClass.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
