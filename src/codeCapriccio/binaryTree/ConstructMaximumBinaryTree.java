package codeCapriccio.binaryTree;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {
    /*
    * 题意（leetcode654. 最大二叉树）：
    *   给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:创建一个根节点，其值为nums 中的最大值。
    *   递归地在最大值左边的子数组前缀上构建左子树。递归地在最大值 右边 的子数组后缀上构建右子树。
    * 解题思路：
    * */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;
        int maxIndex = findMaxIndex(nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        int[] leftNums = Arrays.copyOf(nums, maxIndex);
        int[] rightNums = Arrays.copyOfRange(nums, maxIndex+1, nums.length);
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);
        return root;
    }

    public int findMaxIndex(int[] nums){
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i =0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
