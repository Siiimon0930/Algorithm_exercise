package codeCapriccio.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* leetcode513. 找树左下角的值:
*   给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
* 解题思路：1.层序 2.递归-注意回溯
*/
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        int result = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                if(i == 0){
                    result = temp.val;
                }
                if(temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return result;
    }

    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue2(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
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
        if (root.left != null) findLeftValue(root.left,deep + 1); // 隐藏着回溯
        if (root.right != null) findLeftValue(root.right,deep + 1); // 隐藏着回溯
    }
}
