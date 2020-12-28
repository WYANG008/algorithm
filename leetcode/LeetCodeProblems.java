import array.MergeSortedArray;
import array.MinimumSizeSubarraySum;
import array.Pattern132;
import matrix.Search2DMatrix;
import dfs.CombinationSum;
import string.LongestSubstringWithoutRepeatingCharacters;
import linkedList.RemoveNthNodeFromEndOfList;
import math.HammingDistance;
import matrix.MaxAreaOfIsland;
import array.SearchInRotatedSortedArray;
import stackAndQueue.ImplementQueueUsingStacks;
import array.MedianOfTwoSortedArrays;
import array.RotateArray;
import dynamicprogramming.ClimbingStairs;
import linkedList.ReverseLinkedList;
import tree.BinaryTreeZigzagLevelOrderTraversal;
import coding.StringCompression;
import matrix.ReconstructA2RowBinaryMatrix;
import dynamicprogramming.MaximalSquare;

public enum LeetCodeProblems {
    MergeSortedArray(88, new MergeSortedArray()), // bytedance
    MinimumSizeSubarraySum(209, new MinimumSizeSubarraySum()), // bytedance
    Pattern132(456, new Pattern132()),        // bytedance
    Search2DMatrix(74, new Search2DMatrix()), //bytedance
    CombinationSum(39, new CombinationSum()) , //bytedance
    LongestSubstringWithoutRepeatingCharacters(3, new LongestSubstringWithoutRepeatingCharacters()) , //bytedance
    RemoveNthNodeFromEndOfList(19, new RemoveNthNodeFromEndOfList()), //bytedance
    HammingDistance(461, new HammingDistance()), // bytedance  -> checked
    MaxAreaOfIsland(695, new MaxAreaOfIsland()), // bytedance
    SearchInRotatedSortedArray(33, new SearchInRotatedSortedArray()), // bytedance
    ImplementQueueUsingStacks(232, new ImplementQueueUsingStacks()), // bytedance
    MedianOfTwoSortedArrays(4, new MedianOfTwoSortedArrays()),
    RotateArray(189, new RotateArray()), //bytedance
    ClimbingStairs(70, new ClimbingStairs()), // bytedance
    ReverseLinkedList(206, new ReverseLinkedList()), // bytedance
    BinaryTreeZigzagLevelOrderTraversal(103, new BinaryTreeZigzagLevelOrderTraversal()), // bytedance
    StringCompression(443, new StringCompression()), // bytedance
    ReconstructA2RowBinaryMatrix(1253, new ReconstructA2RowBinaryMatrix()),
    MaximalSquare(221, new MaximalSquare()), //bytedance
    ;

    // 统计数组里unique平方数量的个数: https://www.cnblogs.com/xudong-bupt/p/4002765.html
    // sort a special list and try to do it in linear time O(n)
    // 给一个数组，前半部分ascending后半部分desc, 变成升数列，去掉重复
    // 求解最短路径问题
    public int number;
    public Object obj;

    private LeetCodeProblems(int number, Object obj) {
        this.number = number;
        this.obj = obj;
    }

}
