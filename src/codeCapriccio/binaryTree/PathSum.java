package codeCapriccio.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    /*
     * 题意（leetcode113. 路径总和 II）：给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出《所有》 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 解题思路：类似HasPathSum leetcode112. 路径总和
     *
     * */
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return res;
        path.add(root.val);
        findPath(root, targetSum-root.val);
        return res;
    }

    public void findPath(TreeNode root, int targetSum){
        if(root.left == null && root.right == null && targetSum != 0)
            return;
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(path));         // 1.这不能直接add（path）因为这是浅拷贝，后面递归中path的操作会影响到最终的结果
            return;
        }

        if(root.left != null){
            path.add(root.left.val);
            findPath(root.left, targetSum - root.left.val);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            path.add(root.right.val);
            findPath(root.right, targetSum - root.right.val);
            path.remove(path.size()-1);
        }
        return;
    }
}
