package codeCapriccio.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    /*
    * 题意（98. 验证二叉搜索树）：给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    * 解题思路：
    *   1. 递归法：后序思想，先判断左右子树是否符合条件，而后判断max（left）< root.val && min(right) > root.val
    *   2. 巧方法：根据二叉搜索树中序遍历是递增序列的特性来判断
    * 注意：不能只是简单判断每个节点左节点小于root，右节点大于root！
    */

    // 1.递归法
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        if(root.left == null && root.right != null){
            int rightMin = findRightMin(root.right);
            return isValidBST(root.right) && root.val < rightMin;
        }
        if(root.left != null && root.right == null){
            int leftMax = findLeftMax(root.left);
            return isValidBST(root.left) && root.val > leftMax;
        }
        int leftMax = findLeftMax(root.left);
        int rightMin = findRightMin(root.right);
        return isValidBST(root.left) && isValidBST(root.right) && root.val > leftMax && root.val < rightMin;
    }

    public int findLeftMax(TreeNode root){
        while(root.right != null)
            root = root.right;
        return root.val;
    }

    public int findRightMin(TreeNode root){
        while(root.left != null)
            root = root.left;
        return root.val;
    }

    // 2.巧方法
    private List<Integer> traversal = new ArrayList<>();

    public void inorderTraversal(TreeNode root){
        if(root == null)
            return;
        inorderTraversal(root.left);
        traversal.add(root.val);
        inorderTraversal(root.right);
    }

    public boolean isValidBST2(TreeNode root){
        traversal.clear();
        inorderTraversal(root);
        for (int i = 0; i < traversal.size() - 1; i++) {
            if(traversal.get(i) >= traversal.get(i+1))
                return false;
        }
        return true;
    }

}
