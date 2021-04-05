package tree;

/**
 * leetcode 654
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0,nums.length - 1);
    }

    TreeNode build(int[] nums, int lo, int hi) {
        if(lo > hi) return null;

        if(lo == hi) return new TreeNode(nums[lo]);

        int maxIdx = lo;
        int maxVal = nums[lo];
        for(int i = lo; i <=hi; i++) {
            if(nums[i] > maxVal) {
                maxIdx = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);

        TreeNode left = build(nums, lo, maxIdx -1);
        TreeNode right = build(nums, maxIdx + 1, hi);

        root.left = left;
        root.right = right;

        return root;

    }

    public static void main(String[] args) {
        MaximumBinaryTree testRunner = new MaximumBinaryTree();
        int[] nums = {3,2,1,6,0,5};

        TreeNode node = testRunner.constructMaximumBinaryTree(nums);
    }
}
