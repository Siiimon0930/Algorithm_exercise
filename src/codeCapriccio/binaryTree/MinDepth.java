package codeCapriccio.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public interface MinDepth {
    /*
    * 题意（111. 二叉树的最小深度）：最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    * 解题思路：
    *   1. 递归法
    *   2. 迭代法
    * */

    // 1. 递归法（后序）
    default int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        else{
            int res;
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            // 这里不能直接1 + Math.min(leftDepth, rightDepth)，因为需要到叶子节点才是最短路径。
            if(root.left == null && root.right != null)
                res = 1 + rightDepth;
            else if (root.left != null && root.right == null) {
                res = 1 + leftDepth;
            }else{
                res = 1 + Math.min(leftDepth, rightDepth);
            }
            return res;
        }
    }

    // 2. 迭代法（层序遍历，一层一层的来，当第一次碰到叶子节点时的深度就是最小深度）
    default int minDepth2(TreeNode root){
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.right == null && temp.left == null)
                    return depth;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return depth;
    }
}
