package codeCapriccio.binaryTree;

/*
* leetcode404. 左叶子之和: 给定二叉树的根节点 root ，返回所有左叶子之和。
* 解题思路：遍历
*/
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right== null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            return root.left.val + sumOfLeftLeaves(root.right);
        }else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }


}
