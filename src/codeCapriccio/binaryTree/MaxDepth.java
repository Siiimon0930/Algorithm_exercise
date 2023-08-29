package codeCapriccio.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* leetcode104. 二叉树的最大深度:给定一个二叉树 root ，返回其最大深度。
* 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
* 解题思路：1.层序-层数 2.递归后序-max（左，右）+ 1
*/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int count = 0;
        if(root == null)
            return count;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            count++;
        }
        return count;
    }

    public int maxDepth2(TreeNode root) {
        int count = 0;
        if(root == null)
            return count;

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        int depth = Math.max(left, right) + 1;
        return depth;
    }
}
