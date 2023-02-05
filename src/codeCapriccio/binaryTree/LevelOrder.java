package codeCapriccio.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public interface LevelOrder {
    /*
    * 题目描述（leetcode102）：给你二叉树的根节点 root ，返回其节点值的 层序遍历 。
    * 输入：root = [3,9,20,null,null,15,7] 输出：[[3],[9,20],[15,7]]
    * 解题思路：题目要求的输出是一个二维List集合，即每个一维List为一层，那么使用两个队列来遍历，遍历完的条件是两个队列同时为空，每一层出队后的子节点加入到另一层。
    * */
    default List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();

        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    TreeNode tempNode = q1.poll();
                    tempList.add(tempNode.val);
                    if(tempNode.left != null)
                        q2.add(tempNode.left);
                    if(tempNode.right != null)
                        q2.add(tempNode.right);
                }
            } else{
                while(!q2.isEmpty()){
                    TreeNode tempNode = q2.poll();
                    tempList.add(tempNode.val);
                    if(tempNode.left != null)
                        q1.add(tempNode.left);
                    if(tempNode.right != null)
                        q1.add(tempNode.right);
                }
            }
            res.add(tempList);
        }

        return res;
    }
}
