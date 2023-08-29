package codeCapriccio.binaryTree;

/*
* leetcode226. 翻转二叉树:给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
* 解题思路：后序递归
*/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
