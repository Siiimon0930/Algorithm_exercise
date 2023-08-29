package codeCapriccio.binaryTree;

/*
* leetcode111. 二叉树的最小深度:
*   给定一个二叉树，找出其最小深度。
*   最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
*   说明：叶子节点是指没有子节点的节点。
* 解题思路：递归后序-minDepth = Min(left, right) + 1
*/
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // 需要注意 当左空右不空 或者 左不空右空 这两种情况不能 采用 Min(left, right) + 1
        if(root.left == null && root.right != null)
            return right + 1;
        else if (root.left != null && root.right == null) {
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }
}
