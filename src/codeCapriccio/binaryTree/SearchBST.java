package codeCapriccio.binaryTree;

public class SearchBST {
    /*
    * 题意（700. 二叉搜索树中的搜索）：给定二叉搜索树（BST）的根节点root和一个整数值val。
    *   你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
    * 解题思路：
    *   1. 递归法：二叉搜索树，即是二叉排序树，左小右大，二分法
    *   2. 迭代法：根据大小指引
    */

    // 1. 递归法
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        if(root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    // 2. 迭代法
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null){
            if(root.val == val)
                return root;
            else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
