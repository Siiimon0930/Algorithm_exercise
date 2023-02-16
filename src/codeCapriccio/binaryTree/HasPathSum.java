package codeCapriccio.binaryTree;

public interface HasPathSum {
    /*
    * 题意（leetcode112. 路径总和）：给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
    *   判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
    *解题思路：
    *   1. 递归法（回溯）：每经过一个节点减去这个节点的val，当到叶子节点，且targetSum=0时说明存在
    * */


    // 1. 递归法（回溯）
    default boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && targetSum - root.val != 0)
            return false;
        if(root.left == null && root.right == null && targetSum - root.val == 0)
            return true;
        if(root.left != null){
            targetSum -= root.val;
            if(hasPathSum(root.left, targetSum))
                return true;
            targetSum += root.val;
        }
        if(root.right != null){
            targetSum -= root.val;
            if(hasPathSum(root.right, targetSum))
                return true;
            targetSum += root.val;
        }
        return false;
    }
    // 递归法精缩
    default boolean hasPathSum2(TreeNode root, int targetSum){
        if(root == null)
            return false;
        if(root.left == null && root.right == null && targetSum - root.val != 0)
            return false;
        if(root.left == null && root.right == null && targetSum - root.val == 0)
            return true;
        if(hasPathSum2(root.left, targetSum-root.val))
            return true;
        if(hasPathSum2(root.right, targetSum-root.val))
            return true;
        return false;
    }


}
