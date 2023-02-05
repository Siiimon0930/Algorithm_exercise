package codeCapriccio.binaryTree;

import java.util.Stack;

public interface InvertTree {
    /*
    * 题意（leetcode226）：翻转二叉树
    * 解题思路：
    *   1. 递归法
    *   2. 迭代法
    * */

    // 1. 递归法
    default TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        else{
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

    // 2. 迭代法，可以使用迭代先序遍历来模拟
    default TreeNode invertTree2(TreeNode root) {
        if(root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode tempNode = stack.pop();
            TreeNode temp = tempNode.left;
            tempNode.left = tempNode.right;
            tempNode.right = temp;
            if(tempNode.left != null)
                stack.push(tempNode.left);
            if(tempNode.right != null)
                stack.push(tempNode.right);
        }
        return root;
    }
}
