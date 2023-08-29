package codeCapriccio.binaryTree;

/*
* leetcode110. 平衡二叉树:给定一个二叉树，判断它是否是高度平衡的二叉树。
* 解题思路：从底向上判断
*/
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        // 先判断当前节点的左右子树高度差是否满足要求
        if(Math.abs(left - right) > 1)
            return false;
        // 左右子树高度差是否满足要求的前提下再取决于左右树是否也同时为平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getMaxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
