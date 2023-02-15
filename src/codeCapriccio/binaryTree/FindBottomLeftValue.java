package codeCapriccio.binaryTree;


import java.util.ArrayDeque;
import java.util.Queue;

public interface FindBottomLeftValue {
    /*
    * 题意（leetcode513. 找树左下角的值）：给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
    * 解题思路：
    *   1. 迭代法（层序）
    *   2. 递归法（藏着回溯）
    * */

    // 1. 迭代法（层序）
    default int findBottomLeftValue(TreeNode root) {
        // 题目假设二叉树至少有一个根节点了，无需判空
        Queue<TreeNode> queue = new ArrayDeque<>();
        int bottomLeft = root.val;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(i == 0)
                    bottomLeft = temp.val;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return bottomLeft;
    }

    // 2. 递归法（藏在回溯）
    class Solution {
        private int Deep = -1;
        private int value = 0;
        public int findBottomLeftValue(TreeNode root) {
            value = root.val;
            findLeftValue(root,1);
            return value;
        }

        private void findLeftValue (TreeNode root,int deep) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                if (deep > Deep) {
                    value = root.val;
                    Deep = deep;
                }
            }
            if (root.left != null) findLeftValue(root.left,deep + 1);
            if (root.right != null) findLeftValue(root.right,deep + 1);
        }
    }
}
