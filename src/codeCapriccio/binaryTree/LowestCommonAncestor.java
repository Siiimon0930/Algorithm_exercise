package codeCapriccio.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    /*
    * 题意（leetcode236. 二叉树的最近公共祖先）：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    * 解题思路：
    *   1. 得到这两条路径，然后就是类似于求两条链表公共节点一样了。（没实现！）
    *   2. 代码随想录解法：后序回溯，一个节点如果左子树出现p，右子树出现q，则该节点是公共节点，返回自身往上。
    */

    // 2. 后序回溯

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        // 这个if是关键，这里是为什么可以包括q或者p本身是公共祖先这种情况的原因
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        }else
            return null;
    }


}
