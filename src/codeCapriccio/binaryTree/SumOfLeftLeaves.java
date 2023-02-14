package codeCapriccio.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public interface SumOfLeftLeaves {
    /*
    * 题意（404. 左叶子之和）：给定二叉树的根节点 root ，返回所有左叶子之和。
    * 解题思路：
    *   1. 递归法（后序思想）
    *   2. 迭代法（层序一个个判断左叶子节点）
    * */


    // 1. 递归后序
    default int sumOfLeftLeaves(TreeNode root) {
        if(root == null || isLeaf(root))                    // 空节点或者叶子节点
            return 0;
        int leftValue = 0;
        if(root.left != null && isLeaf(root.left))     // 左孩子是叶子节点
            leftValue = root.left.val;
        return leftValue + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


    default boolean isLeaf(TreeNode root){
        if(root != null && root.left == null && root.right == null)
            return true;
        else
            return false;
    }

    // 2. 迭代层序
    default int sumOfLeftLeaves2(TreeNode root){
        if(root == null || isLeaf(root))
            return 0;
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            if(tempNode.left != null)
                queue.add(tempNode.left);
            if(tempNode.right != null)
                queue.add(tempNode.right);
            if(isLeaf(tempNode.left))
                sum += tempNode.left.val;
        }
        return sum;
    }

    // 3. 迭代前序
    default int sumOfLeftLeaves3(TreeNode root){
        if(root == null || isLeaf(root))
            return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode tempNode = stack.pop();
            if(isLeaf(tempNode.left))
                sum += tempNode.left.val;
            if(tempNode.right != null)
                stack.push(tempNode.right);
            if(tempNode.left != null)
                stack.push(tempNode.left);
        }
        return sum;
    }

    // 3. 迭代中序
    default int sumOfLeftLeaves4(TreeNode root){
        if(root == null || isLeaf(root))
            return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.empty() || root != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else {
                current = stack.pop();
                if(isLeaf(current.left))
                    sum += current.left.val;
                current = current.right;
            }
        }
        return sum;
    }

}
