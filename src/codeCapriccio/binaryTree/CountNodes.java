package codeCapriccio.binaryTree;

/*
* leetcode222. 完全二叉树的节点个数: 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
* 解题思路：1. 左 + 右 + 1
*/
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }
}
