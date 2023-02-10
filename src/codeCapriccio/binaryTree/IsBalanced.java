package codeCapriccio.binaryTree;

public interface IsBalanced {
    /*
    * 题意（110. 平衡二叉树）：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
    * 解题思路：
    *   1. 递归法（后序思想）：递归求左右子树的高度
    *
    * */


    default boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        else if (!isBalanced(root.left) || !isBalanced(root.right)) {   // 先判断左右子树，即左右中
            return false;
        } else{
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            return Math.abs(leftDepth - rightDepth) <= 1;
        }
    }

    default int getDepth(TreeNode root){
        if(root == null)
            return 0;
        else
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
