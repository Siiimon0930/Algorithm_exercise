package codeCapriccio.binaryTree;

import java.util.Arrays;

public class SortedArrayToBST {
    /*
    * 题意（leetcode108. 将有序数组转换为二叉搜索树）：
    *   给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
    * 解题思路：
    *   1.递归法：每次找数组最中间元素，创建节点，把数组分为左右两个子数组继续去创建节点
    */

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        int curIndex = nums.length / 2;
        int[] leftNums = Arrays.copyOfRange(nums, 0, curIndex);
        int[] rightNums = Arrays.copyOfRange(nums, curIndex + 1, nums.length);
        TreeNode root = new TreeNode(nums[curIndex]);
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);
        return root;
    }

    // -----------------------第二遍-------------------------
    public TreeNode sortedArrayToBST2(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        int midIndex = nums.length / 2;
        int[] leftNums = Arrays.copyOfRange(nums, 0, midIndex);
        int[] rightNums = Arrays.copyOfRange(nums, midIndex+1, nums.length);
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = sortedArrayToBST2(leftNums);
        root.right = sortedArrayToBST2(rightNums);
        return root;
    }
}
