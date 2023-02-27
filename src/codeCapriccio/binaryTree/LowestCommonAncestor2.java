package codeCapriccio.binaryTree;

public class LowestCommonAncestor2 {
    /*
    * 题意（leetcode235. 二叉搜索树的最近公共祖先）：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    * 解题思路：
    *   1. 普通方法：与普通树求法一样，后序思想。
    *   2. BST特性方法：从上往下遍历，当p，和q的值一个大于root一个小于root时，root就是最近公共祖先；
    *       当p和q都小于root时，说明p和q都在root左子树，再去左子树找，p和q都大于root都去右子树找。
    */

    // 1.普通方法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        else if(left == null && right != null)
            return right;
        else if(left != null && right == null)
            return left;
        else
            return null;
    }

    // 2.BST特性方法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return root;
        if((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val))    // root在p和q之间
            return root;
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor2(root.left, p, q);
        else
            return lowestCommonAncestor2(root.right, p, q);
    }
}
