package codeCapriccio.binaryTree;

public class TrimBST {
    /*
    * 题意（leetcode669. 修剪二叉搜索树）：
    *   给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
    *   修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
    * 解题思路：
    *   1.BST删除节点的判断思路
    *   2.更巧妙的判断思路，当root.val < low时，直接返回trim（right），root.val > high时，返回trim（left）
    *
    */

    // 1.BST删除节点的判断思路
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        if(root.val >= low && root.val <= high){
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }else{
            // 1.如果左右子树都为空，直接删除返回空
            if(root.left == null && root.right == null)
                return null;
            // 2.左为空，右不为空，返回trim（right）
            else if(root.left == null && root.right != null)
                return trimBST(root.right, low, high);
            // 3.右为空，左不为空，返回trim（left）
            else if(root.left != null && root.right == null)
                return trimBST(root.left, low, high);
            // 4.左右都不为空，则先把左子树挂到右子树最小节点的左边，再trim（right）
            else{
                TreeNode rightMin = root.right;
                while(rightMin.left != null)
                    rightMin = rightMin.left;
                rightMin.left = root.left;
                return trimBST(root.right, low, high);
            }
        }
    }

    // 2.更巧妙的判断思路
    public TreeNode trimBST2(TreeNode root, int low, int high){
        if(root == null)
            return null;
        if(root.val >= low && root.val <= high){
            root.left = trimBST2(root.left, low, high);
            root.right = trimBST2(root.right, low, high);
            return root;
        } else if (root.val < low) {
            return trimBST2(root.right, low, high);
        }else{
            return trimBST2(root.left, low, high);
        }
    }
}
