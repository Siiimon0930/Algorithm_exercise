package codeCapriccio.binaryTree;

/*
* leetcode101. 对称二叉树:给你一个二叉树的根节点 root ， 检查它是否轴对称。
* 解题思路：内侧、外侧，从底至上
*/
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return compare(root.left, root.right);

    }

    public boolean compare(TreeNode left, TreeNode right){
        if (left == null && right != null)
            return false;
        else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }

        // 获取内外侧的比较结果，最终结果是内外侧结果取&&
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        boolean result = outside && inside;
        return result;
    }
}
