package codeCapriccio.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public interface CountNodes {
    /*
    * 题目描述（222. 完全二叉树的节点个数）
    * 解题思路：
    *   1.普通二叉树方法：
    *       1.1 迭代法（层序遍历）O（n）
    *       1.2 递归法（后序 左右中）
    *   2. 完全二叉树法 O（logn * logn）：
    *       一颗完全二叉树一定可以分为若干颗满二叉树，满二叉树可以用公式计算。
    * */

    // 1.1 迭代法（层序遍历）
    default int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int count = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
            count++;
        }
        return count;
    }

    // 1.2 递归法
    default int countNodes2(TreeNode root){
        if(root == null)
            return 0;
        else{
            return countNodes2(root.left) + countNodes2(root.right) + 1;
        }
    }

    // 2 完全二叉树法
    default int countNodes3(TreeNode root){
        // 边界条件
        if(root == null)
            return 0;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int depthLeft = 0, depthRight = 0;
        while(leftNode != null){
            depthLeft++;
            leftNode = leftNode.left;
        }
        while(rightNode != null){
            depthRight++;
            rightNode = rightNode.right;
        }
        if(depthLeft == depthRight)             // 对于完全二叉树来说，如果向左递归的深度等于向右递归的深度相等就是满二叉树
            return (2<<depthLeft) - 1;          // 这里要注意移位运算优先级小于加减，所以需要用括号；同时左移的位数不要搞错了，就是depthLeft，不需要+1
        else
            return countNodes3(root.left) + countNodes3(root.right) + 1;
    }
}
