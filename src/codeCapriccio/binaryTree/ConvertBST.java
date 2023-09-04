package codeCapriccio.binaryTree;

public class ConvertBST {
    /*
    * 题意（leetcode538. 把二叉搜索树转换为累加树）：
    *   给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
    *   使每个节点node的新值等于原树中大于或等于node.val的值之和。
    * 解题思路：
    *   1.递归法：右中左
    */

    // 1.递归法

    private int curSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return root;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root){
        if(root == null)
            return;
        traversal(root.right);
        curSum += root.val;
        root.val = curSum;
        traversal(root.left);
    }

    // ------------------------第二遍----------------------------
    // 思路，中序遍历，右中左
    public TreeNode convertBST2(TreeNode root) {
        if (root == null)
            return root;
        root.right = convertBST(root.right);
        curSum += root.val;
        root.val = curSum;
        root.left = convertBST(root.left);
        return root;
    }
}
