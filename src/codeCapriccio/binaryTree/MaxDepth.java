package codeCapriccio.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public interface MaxDepth {
    /*
    * 题意（104. 二叉树的最大深度）
    * 解题思路：
    *   1. 递归法
    *   2. 迭代法
    * */

    // 1. 递归法
    default int maxDepth(TreeNode root) {
        int res = 0;
        if(root == null)
            return 0;
        else
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 2. 迭代法
    default int maxDepth2(TreeNode root){
        int res = 0;
        if(root == null)
            return res;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while(!que.isEmpty()){
            res++;
            int size = que.size();                  // 单独设size变量是必要的，不能放在循环条件里，否则每次循环的size是个新值
            for(int i = 0; i < size; i++){
                TreeNode temp = que.poll();
                if(temp.left !=null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
            }
        }
        return res;
    }
}
