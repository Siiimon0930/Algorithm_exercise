package codeCapriccio.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference {
    /*
    * 题意（leetcode530. 二叉搜索树的最小绝对差）：
    *   给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。差值是一个正数，其数值等于两值之差的绝对值。
    * 解题思路：
    *   1. 数组法：把二叉搜索树的中序遍历结果（递增序）用数组保存起来，数组相邻元素差值最小处即是结果
    *   2. 双指针法：也是吃准二叉搜索树的最小绝对差肯定是相邻两个节点的差值，那么设置一个pre指针一个current指针来计算差值。
    */

    // 1. 数组法
    public int getMinimumDifference(TreeNode root) {
        List<Integer> traversalList = new ArrayList<>();
        inorderTraversal(root, traversalList);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < traversalList.size()-1; i++) {
            int temp = traversalList.get(i + 1) - traversalList.get(i);
            if(temp < minDifference)
                minDifference = temp;
        }
        return minDifference;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result){
        if(root == null)
            return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
    
    // 2. 双指针法
    private int result = Integer.MAX_VALUE;
    //  不能这么写，pre必须初始化为null  private TreeNode pre = new TreeNode();
    private TreeNode pre = null;

    public int getMinimumDifference2(TreeNode root){
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root){
        if(root == null)
            return;
        traversal(root.left);
        if(pre != null){
            int difference = root.val - pre.val;
            if(difference < result)
                result = difference;
        }
        pre = root;
        traversal(root.right);
    }
}
